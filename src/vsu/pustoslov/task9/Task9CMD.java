package vsu.pustoslov.task9;

import java.io.Console;
import java.io.FileNotFoundException;
import java.util.List;

public class Task9CMD {
    private static final Console CONSOLE = System.console();

    public static void main(String[] args) {
        if (CONSOLE == null) {
            return;
        }

        final String inputFile = CONSOLE.readLine("Enter the name of input file please: ");
        final String outputFile = CONSOLE.readLine("Enter the name of output file please: ");
        final ListReverse listReverse = new ListReverse();
        final InputFileReader inputFileReader = new InputFileReader();
        final OutputFileWriter outputFileWriter = new OutputFileWriter();
        try {
            final List<Integer> answerList = listReverse.createNewList(inputFileReader.readListFromFile(inputFile));
            outputFileWriter.saveFile(answerList, outputFile);
        } catch (FileNotFoundException e) {
            System.err.println("Can't find the file, try again");
        }
    }
}
