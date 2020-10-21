package vsu.pustoslov.task4;

import vsu.pustoslov.commons.ConsoleReader;

public class Task4 {
    public static void main(String[] args) {
        final ConsoleReader consoleReader = new ConsoleReader();
        final int k = consoleReader.readInt("Input K: ");

        System.out.printf("Answer = %s", numberKOfRow(k));
    }

    private static int numberKOfRow(int k) {
        int counter = 0;

        for (int i = 1; ; i++) {
            double currentValue = i;
            int amountOfDigitsInANumber = getNumbersOfDigits(i);
            while (amountOfDigitsInANumber > 0) {
                amountOfDigitsInANumber--;
                final int digitKOfARow = (int) (currentValue / Math.pow(10, amountOfDigitsInANumber));
                currentValue -= digitKOfARow * Math.pow(10, amountOfDigitsInANumber);
                counter++;

                if (counter == k) {
                    return digitKOfARow;
                }
            }
        }
    }

    private static int getNumbersOfDigits(int number) {
        int numberOfDigits = 0;
        while (number != 0) {
            numberOfDigits++;
            number /= 10;
        }
        return numberOfDigits;
    }
}

