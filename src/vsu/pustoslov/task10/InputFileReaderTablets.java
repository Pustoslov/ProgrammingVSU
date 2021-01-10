package vsu.pustoslov.task10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFileReaderTablets {
    public List<Tablet> readListOfTabletsFromFile(String inputFile) throws FileNotFoundException {
        final File file = new File(inputFile);
        final Scanner scanner = new Scanner(file);
        final List<Tablet> listOfTablets = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String nextTablet = scanner.nextLine();
            String[] fields = nextTablet.split("(\\s|[,;])+");
            String name = fields[0];
            int memory = Integer.parseInt(fields[1]);
            double rate = Double.parseDouble(fields[2]);
            double price = Double.parseDouble(fields[3]);
            Tablet tablet = new Tablet(name, memory, rate, price);
            listOfTablets.add(tablet);
        }
        scanner.close();
        return listOfTablets;
    }
}