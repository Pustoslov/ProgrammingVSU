package vsu.pustoslov.task10;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import ru.vsu.cs.util.JTableUtils;
import ru.vsu.cs.util.SwingUtils;

public class FrameMain extends JFrame {
    private JTable inputTable;
    private JPanel panelMain;
    private JButton loadingFromFileButton;
    private JButton executeButton;
    private JButton saveToFileOutputButton;
    private JFormattedTextField memorySize;
    private JFormattedTextField necessaryRate;
    private JFormattedTextField quantityOfTablets;
    private JTextArea answerTextArea;

    private final JFileChooser FILE_CH00SER_OPEN = new JFileChooser();
    private final JFileChooser FILE_CHOOSER_SAVE = new JFileChooser();

    public FrameMain() {
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(inputTable, 400, true,
                true, false, true);

        inputTable.setRowHeight(40);

        FILE_CH00SER_OPEN.setCurrentDirectory(new File("."));
        FILE_CHOOSER_SAVE.setCurrentDirectory(new File("."));

        FileFilter FILE_NAME_TXT_EXTENSION_FILTER = new FileNameExtensionFilter("Text files", "txt");
        FILE_CH00SER_OPEN.addChoosableFileFilter(FILE_NAME_TXT_EXTENSION_FILTER);
        FILE_CHOOSER_SAVE.addChoosableFileFilter(FILE_NAME_TXT_EXTENSION_FILTER);

        FILE_CHOOSER_SAVE.setAcceptAllFileFilterUsed(false);
        FILE_CHOOSER_SAVE.setDialogType(JFileChooser.SAVE_DIALOG);
        FILE_CHOOSER_SAVE.setApproveButtonText("Save");

        answerTextArea.setEnabled(false);


        addJTextFieldMemorySize();
        addJTextFieldNecessaryRate();
        addJTextFieldQuantityOfTablets();


        addLoadingFromFileButton();
        addExecuteButton();
        addSaveToFileOutputButton();
    }

    private void addJTextFieldMemorySize() {
        memorySize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                try {

                    Integer.parseInt(memorySize.getText());

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "Please insert Valid Number Only (int type)");

                    memorySize.setText(memorySize.getText().substring(0, memorySize.getText().length() - 1));
                }
                JOptionPane.showMessageDialog(FrameMain.this,
                        "Necessary memory size: " + memorySize.getText());
            }
        });
    }

    private void addJTextFieldNecessaryRate() {
        necessaryRate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                try {

                    Double.parseDouble(necessaryRate.getText());

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "Please insert Valid Number Only (double type)");

                    necessaryRate.setText(necessaryRate.getText().substring(0, necessaryRate.getText().length() - 1));
                }
                JOptionPane.showMessageDialog(FrameMain.this,
                        "Necessary rate: " + necessaryRate.getText());
            }
        });
    }

    private void addJTextFieldQuantityOfTablets() {
        quantityOfTablets.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent actionEvent) {

                try {

                    Integer.parseInt(quantityOfTablets.getText());

                } catch (Exception e) {

                    JOptionPane.showMessageDialog(null, "Please insert Valid Number Only (int type)");

                    quantityOfTablets.setText(quantityOfTablets.getText().substring(0, quantityOfTablets.getText().length() - 1));
                }
                JOptionPane.showMessageDialog(FrameMain.this,
                        "Quantity of tablets: " + quantityOfTablets.getText());
            }
        });
    }

    private void addLoadingFromFileButton() {
        loadingFromFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (FILE_CH00SER_OPEN.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        final InputFileReaderTablets inputFileReaderTablets = new InputFileReaderTablets();
                        final List<Tablet> inputListOfTablets =
                                inputFileReaderTablets.readListOfTabletsFromFile(FILE_CH00SER_OPEN.getSelectedFile().getPath());
                        final Tablet[] arrayOfTablets = inputListOfTablets.toArray(new Tablet[0]);
                        final String[] linesOfTablets = new String[arrayOfTablets.length];

                        for (int i = 0; i < arrayOfTablets.length; i++) {
                            linesOfTablets[i] = arrayOfTablets[i].toString();
                        }

                        JTableUtils.writeArrayToJTable(inputTable, linesOfTablets);
                    }
                } catch (Exception e) {
                    SwingUtils.showInfoMessageBox("Entrance data error");
                }
            }
        });
    }

    private void addExecuteButton() {
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    final String[] arrayOfLines = JTableUtils.readStringArrayFromJTable(inputTable);
                    final List<Tablet> listOfTablets = new ArrayList<>();
                    for (String line : arrayOfLines) {
                        String[] fields = line.split("(\\s|[,;])+");
                        String name = fields[0];
                        int memory = Integer.parseInt(fields[1]);
                        double rate = Double.parseDouble(fields[2]);
                        double price = Double.parseDouble(fields[3]);
                        Tablet tablet = new Tablet(name, memory, rate, price);
                        listOfTablets.add(tablet);
                    }
                    final TabletChoice tabletChoice = new TabletChoice();

                    int memory = Integer.parseInt(memorySize.getText());
                    double rate = Double.parseDouble(necessaryRate.getText());
                    int quantityOfTabletsInt = Integer.parseInt(quantityOfTablets.getText());


                    Tablet bestTablet = tabletChoice.theBestTablet(listOfTablets, memory, rate);

                    if (arrayOfLines.length != 0) {
                        answerTextArea.setText("Best choice for you is\nName: " + bestTablet.getName() + "\nMemory size: " + bestTablet.getMemory() +
                                "\nUsers rate: " + bestTablet.getRate() + "\nPrice per one: " + bestTablet.getPrice() +
                                "\nTotal price for " + quantityOfTabletsInt + " tablets = " +
                                bestTablet.getPrice() * quantityOfTabletsInt);
                    } else {
                        answerTextArea.setText("Enter non-empty list please");
                    }
                } catch (Exception e) {
                    SwingUtils.showInfoMessageBox("Entrance data error");
                }
            }
        });
    }

    private void addSaveToFileOutputButton() {
        saveToFileOutputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (FILE_CHOOSER_SAVE.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        final OutputFileWriterTablets outputFileWriterTablets = new OutputFileWriterTablets();


                        String file = FILE_CHOOSER_SAVE.getSelectedFile().getPath();

                        final String[] arrayOfLines = JTableUtils.readStringArrayFromJTable(inputTable);
                        final List<Tablet> listOfTablets = new ArrayList<>();
                        for (String line : arrayOfLines) {
                            String[] fields = line.split("(\\s|[,;])+");
                            String name = fields[0];
                            int memory = Integer.parseInt(fields[1]);
                            double rate = Double.parseDouble(fields[2]);
                            double price = Double.parseDouble(fields[3]);
                            Tablet tablet = new Tablet(name, memory, rate, price);
                            listOfTablets.add(tablet);
                        }
                        final TabletChoice tabletChoice = new TabletChoice();

                        int memory = Integer.parseInt(memorySize.getText());
                        double rate = Double.parseDouble(necessaryRate.getText());
                        Tablet bestTablet = tabletChoice.theBestTablet(listOfTablets, memory, rate);

                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }

                        int quantityOfTabletsInt = Integer.parseInt(quantityOfTablets.getText());

                        outputFileWriterTablets.saveFile(file, bestTablet, quantityOfTabletsInt);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }
}
