package vsu.pustoslov.task9;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import ru.vsu.cs.util.ArrayUtils;
import ru.vsu.cs.util.JTableUtils;
import ru.vsu.cs.util.SwingUtils;

public class FrameMain extends JFrame {
    private JPanel panelMain;
    private JTable tableInput;
    private JButton buttonLoadInputFromFile;
    private JButton buttonRandomInput;
    private JTable tableOutput;
    private JScrollPane scrollPaneTableOutput;
    private JScrollPane scrollPaneTableInput;
    private JButton buttonExecute;
    private JButton buttonSaveOutputIntoFile;

    private final JFileChooser FILE_CH00SER_OPEN = new JFileChooser();
    private final JFileChooser FILE_CHOOSER_SAVE = new JFileChooser();

    public FrameMain() {
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(tableInput, 40, false,
                true, false, true);
        JTableUtils.initJTableForArray(tableOutput, 40, false,
                true, false, true);
        tableInput.setRowHeight(25);
        tableOutput.setRowHeight(25);
        scrollPaneTableInput.setPreferredSize(new Dimension(-1, 90));
        scrollPaneTableOutput.setPreferredSize(new Dimension(-1, 90));


        FILE_CH00SER_OPEN.setCurrentDirectory(new File("."));
        FILE_CHOOSER_SAVE.setCurrentDirectory(new File("."));

        final FileFilter FILE_NAME_TXT_EXTENSION_FILTER = new FileNameExtensionFilter("Text files",
                "txt");

        FILE_CH00SER_OPEN.addChoosableFileFilter(FILE_NAME_TXT_EXTENSION_FILTER);
        FILE_CHOOSER_SAVE.addChoosableFileFilter(FILE_NAME_TXT_EXTENSION_FILTER);

        FILE_CHOOSER_SAVE.setAcceptAllFileFilterUsed(false);
        FILE_CHOOSER_SAVE.setDialogType(JFileChooser.SAVE_DIALOG);
        FILE_CHOOSER_SAVE.setApproveButtonText("Save");

        addLoadingFromFileButton();
        addFillWithRandomButton();
        addExecuteButton();
        addSaveToFileOutputButton();
    }

    private void addLoadingFromFileButton() {
        buttonLoadInputFromFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (FILE_CH00SER_OPEN.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        final InputFileReader inputFileReader = new InputFileReader();
                        final List<Integer> inputList = inputFileReader.readListFromFile(FILE_CH00SER_OPEN.getSelectedFile().getPath());
                        final Integer[] arrayOfInt = inputList.toArray(new Integer[0]);
                        final String[] arrayOfString = new String[arrayOfInt.length];
                        for (int i = 0; i < arrayOfInt.length; i++) {
                            arrayOfString[i] = String.valueOf(arrayOfInt[i]);
                        }
                        JTableUtils.writeArrayToJTable(tableInput, arrayOfString);
                    }
                } catch (Exception e) {
                    SwingUtils.showInfoMessageBox("Enter integer list please");
                }
            }
        });
    }

    private void addFillWithRandomButton() {
        buttonRandomInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = ArrayUtils.createRandomIntArray(tableInput.getColumnCount(), 100);
                    JTableUtils.writeArrayToJTable(tableInput, arr);
                } catch (Exception e) {
                    SwingUtils.showInfoMessageBox("Enter integer list please");
                }
            }
        });
    }

    private void addExecuteButton() {
        buttonExecute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = JTableUtils.readIntArrayFromJTable(tableInput);
                    final List<Integer> inputList = new ArrayList<>();
                    for (Integer value : arr) {
                        inputList.add(value);
                    }
                    final ListReverse listReverse = new ListReverse();
                    final List<Integer> answerList = listReverse.createNewList(inputList);
                    final Integer[] arrayOfInteger = answerList.toArray(new Integer[0]);

                    JTableUtils.writeArrayToJTable(tableOutput, ArrayUtils.toPrimitive(arrayOfInteger));
                } catch (Exception e) {
                    SwingUtils.showInfoMessageBox("Enter integer list please");
                }
            }
        });
    }

    private void addSaveToFileOutputButton() {
        buttonSaveOutputIntoFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (FILE_CHOOSER_SAVE.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        int[] arr = JTableUtils.readIntArrayFromJTable(tableOutput);
                        String file = FILE_CHOOSER_SAVE.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        final List<Integer> inputList = new ArrayList<>();
                        for (Integer value : arr) {
                            inputList.add(value);
                        }
                        final OutputFileWriter outputFileWriter = new OutputFileWriter();
                        outputFileWriter.saveFile(inputList, file);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }
}
