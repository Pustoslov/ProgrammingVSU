package vsu.pustoslov.task5;

import vsu.pustoslov.commons.ConsoleReader;

public class Task5 {

    public static void main(String[] args) {
        final ConsoleReader consoleReader = new ConsoleReader();
        final int h = consoleReader.readInt("Input odd number >=3 : ");
        printPicture(h);
    }

    private static void printPicture(int h) {
        for (int j = 0; j < h; j++) {
            System.out.print("*");
        }

        for (int i = 1; i < (h + 1) / 2; i++) {
            System.out.println();
            for (int j = 0; j < (h + 1) / 2 - i; j++) {
                System.out.print("*");
            }

            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < (h + 1) / 2 - i; j++) {
                System.out.print("*");
            }
        }
    }
}
