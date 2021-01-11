package vsu.pustoslov.commons;

import java.util.Scanner;
import ru.vsu.cs.util.ArrayUtils;

public class ConsoleReader {
    private final Scanner scanner = new Scanner(System.in);

    public double readDouble(String lineForPrinting) {
        System.out.print(lineForPrinting);
        return scanner.nextDouble();
    }

    public int readInt(String lineForPrinting) {
        System.out.print(lineForPrinting);
        return scanner.nextInt();
    }

    public String readString(String lineForPrinting) {
        System.out.print(lineForPrinting);
        return scanner.nextLine();
    }

    public int[] readIntArray() {
        int[] array;

        do {
            System.out.println("Enter non-empty array please");
            array = ArrayUtils.readIntArrayFromConsole();
        } while (array.length == 0);

        return array;
    }
}