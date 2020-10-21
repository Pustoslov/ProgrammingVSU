package vsu.pustoslov.commons;

import java.util.Scanner;

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
}
