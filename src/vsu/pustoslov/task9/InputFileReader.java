package vsu.pustoslov.task9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputFileReader {
    public static List<Integer> readListFromFile(String inputFile) throws FileNotFoundException {
        final File file = new File(inputFile);
        final Scanner scanner = new Scanner(file);
        final List<Integer> introducedList = new ArrayList<>();
        scanner.useDelimiter("(\\s|[,;])+");
        while (scanner.hasNextInt()) {
            introducedList.add(scanner.nextInt());
        }
        scanner.close();
        return introducedList;
    }
}
