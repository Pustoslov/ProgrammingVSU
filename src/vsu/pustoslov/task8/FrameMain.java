package vsu.pustoslov.task8;

import ru.vsu.cs.util.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.*;
import java.awt.event.*;
import java.io.*;

public class FrameMain extends JFrame {

    private JPanel panelMain;
    private JTable inputTable;
    private JButton loadingFromFileButton;
    private JButton fillWithRandomNumbersButton;
    private JButton saveToFileButton;
    private JTable outputTable;
    private JButton saveToFileOutputButton;
    private JButton executeButton;

    public FrameMain() {
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(inputTable, 40, true,
                true, true, true);
        JTableUtils.initJTableForArray(outputTable, 40, true,
                true, true, true);

        inputTable.setRowHeight(25);
        outputTable.setRowHeight(25);

        final JFileChooser fileChooserOpen = new JFileChooser();
        final JFileChooser fileChooserSave = new JFileChooser();

        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));

        final FileFilter filter = new FileNameExtensionFilter("Text files", "txt");

        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        final JMenuBar menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        final JMenu menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("Вид");
        menuBarMain.add(menuLookAndFeel);
        SwingUtils.initLookAndFeelMenu(menuLookAndFeel);

        loadingFromFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        final int[][] arr = ArrayUtils.readIntArray2FromFile(fileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(inputTable, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showInfoMessageBox("Enter int array please");
                }
            }
        });

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

        saveToFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        final int[][] matrix = JTableUtils.readIntMatrixFromJTable(inputTable);
                        String file = fileChooserSave.getSelectedFile().getPath();
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

        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    final int[][] matrix = JTableUtils.readIntMatrixFromJTable(inputTable);
                    final Logic logic = new Logic();
                    JTableUtils.writeArrayToJTable(outputTable, logic.calculateAnswer(matrix));
                } catch (Exception e) {
                    SwingUtils.showInfoMessageBox("Enter int array please");
                }
            }
        });

        saveToFileOutputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        final int[][] matrix = JTableUtils.readIntMatrixFromJTable(outputTable);
                        String file = fileChooserSave.getSelectedFile().getPath();
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
