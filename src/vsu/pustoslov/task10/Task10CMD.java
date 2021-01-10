package vsu.pustoslov.task10;

import java.io.Console;
import java.io.FileNotFoundException;
import java.util.List;

public class Task10CMD {
    private static final Console CONSOLE = System.console();

    public static void main(String[] args) {
        if (CONSOLE == null) {
            return;
        }

        final String inputFile = CONSOLE.readLine("Enter the name of input file please: ");
        final String outputFile = CONSOLE.readLine("Enter the name of output file please: ");
        final int necessaryMemory = Integer.parseInt(CONSOLE.readLine("Necessary memory size: "));
        final double necessaryRate = Double.parseDouble(CONSOLE.readLine("Necessary rate: "));
        final int quantityOfTablets = Integer.parseInt(CONSOLE.readLine("Enter the number of tablets to buy: "));

        final TabletChoice tabletChoice = new TabletChoice();
        final InputFileReaderTablets inputFileReaderTablets = new InputFileReaderTablets();
        final OutputFileWriterTablets outputFileWriterTablets = new OutputFileWriterTablets();

        try {
            final List<Tablet> listOfTablets = inputFileReaderTablets.readListOfTabletsFromFile(inputFile);
            final Tablet bestTablet = tabletChoice.theBestTablet(listOfTablets, necessaryMemory, necessaryRate);
            outputFileWriterTablets.saveFile(outputFile, bestTablet, quantityOfTablets);

        } catch (FileNotFoundException e) {
            System.err.println("Can't find the file, try again");
        }
    }
}