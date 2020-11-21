package vsu.pustoslov.task8;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import ru.vsu.cs.util.ArrayUtils;
import ru.vsu.cs.util.JTableUtils;
import ru.vsu.cs.util.SwingUtils;

public class FrameMain extends JFrame {

    private JPanel panelMain;
    private JTable inputTable;
    private JButton loadingFromFileButton;
    private JButton fillWithRandomNumbersButton;
    private JButton saveToFileButton;
    private JTable outputTable;
    private JButton saveToFileOutputButton;
    private JButton executeButton;

    private final JFileChooser FILE_CH00SER_OPEN = new JFileChooser();
    private final JFileChooser FILE_CHOOSER_SAVE = new JFileChooser();
    private final FileFilter FILE_NAME_TXT_EXTENSION_FILTER = new FileNameExtensionFilter("Text files", "txt");

    public FrameMain() {
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(inputTable, 40, true,
                true, true, true);
        JTableUtils.initJTableForArray(outputTable, 40, true,
                true, true, true);

        inputTable.setRowHeight(40);
        outputTable.setRowHeight(40);

        FILE_CH00SER_OPEN.setCurrentDirectory(new File("."));
        FILE_CHOOSER_SAVE.setCurrentDirectory(new File("."));

        FILE_CH00SER_OPEN.addChoosableFileFilter(FILE_NAME_TXT_EXTENSION_FILTER);
        FILE_CHOOSER_SAVE.addChoosableFileFilter(FILE_NAME_TXT_EXTENSION_FILTER);

        FILE_CHOOSER_SAVE.setAcceptAllFileFilterUsed(false);
        FILE_CHOOSER_SAVE.setDialogType(JFileChooser.SAVE_DIALOG);
        FILE_CHOOSER_SAVE.setApproveButtonText("Save");

        addLoadingFromFileButton();
        addFillWithRandomButton();
        addSaveToFileButton();
        addExecuteButton();
        addSaveToFileOutputButton();
    }


    private void addLoadingFromFileButton() {
        loadingFromFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (FILE_CH00SER_OPEN.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        final int[][] arr = ArrayUtils.readIntArray2FromFile(FILE_CH00SER_OPEN.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(inputTable, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showInfoMessageBox("Enter int array please");
                }
            }
        });
    }

    private void addFillWithRandomButton() {
        fillWithRandomNumbersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    final int[][] matrix = ArrayUtils.createRandomIntMatrix(
                            inputTable.getRowCount(), inputTable.getColumnCount(), 100);
                    JTableUtils.writeArrayToJTable(inputTable, matrix);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }

    private void addSaveToFileButton() {
        saveToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (FILE_CHOOSER_SAVE.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        final int[][] matrix = JTableUtils.readIntMatrixFromJTable(inputTable);
                        String file = FILE_CHOOSER_SAVE.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        ArrayUtils.writeArrayToFile(file, matrix);
                    }
                } catch (Exception e) {
                    SwingUtils.showInfoMessageBox("Enter int array please");
                }
            }
        });
    }

    private void addExecuteButton() {
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    final int[][] matrix = JTableUtils.readIntMatrixFromJTable(inputTable);
                    final MatrixCut logic = new MatrixCut();
                    if (matrix != null) {
                        JTableUtils.writeArrayToJTable(outputTable, logic.trimMatrixToSquare(matrix));
                    }
                } catch (Exception e) {
                    SwingUtils.showInfoMessageBox("Enter int array please");
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
                        final int[][] matrix = JTableUtils.readIntMatrixFromJTable(outputTable);
                        String file = FILE_CHOOSER_SAVE.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        ArrayUtils.writeArrayToFile(file, matrix);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }
}
