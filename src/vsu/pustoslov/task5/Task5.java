package vsu.pustoslov.task5;

import vsu.pustoslov.commons.ConsoleReader;

public class Task5 {
    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        int h = consoleReader.readInt("Input odd number >=3 : ");
        printPicture(h);
    }

    private static void printPicture(int h) {
        for (int i = 0; i < (h + 1) / 2; i++) {
            if (i == 0) {
                for (int j = 0; j < h; j++) {
                    System.out.print("*");
                }
            } else {
                System.out.println();
                for (int j = 0; j < (h + 1) / 2 - i; j++) {
                    System.out.print("*");
                }
                for (int j = 0; j < 2 * i - 1; j++) {
                    System.out.print(" ");
                }
                for (int j = 0; j < (h + 1) / 2 - i; j++) {
                    System.out.print("*");
                }
            }
        }
    }
}
