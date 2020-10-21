package vsu.pustoslov.task6;

import vsu.pustoslov.commons.ConsoleReader;

public class Task6 {
    public static void main(String[] args) {
        ConsoleReader consoleReader = new ConsoleReader();
        final double x = consoleReader.readDouble("Input x please: ");
        final int n = consoleReader.readInt("Input n please: ");
        final double e = consoleReader.readDouble("Input e please: ");
        countRow(x, n, e);
        System.out.printf("4) Function value: %s", Math.cos(x));
    }

    private static void countRow(double x, int n, double e) {
        double sumOfRowN = 0;
        double sumOfRowMoreThanE = 0;
        double sumOfRowETen = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sumOfRowN = sumOfRowN + memberOfARow(x, i);
                if (memberOfARow(x, i) > e) {
                    sumOfRowMoreThanE = sumOfRowMoreThanE + memberOfARow(x, i);
                }
                if (memberOfARow(x, i) > e / 10) {
                    sumOfRowETen = sumOfRowETen + memberOfARow(x, i);
                }
            } else {
                sumOfRowN = sumOfRowN - memberOfARow(x, i);
                if (memberOfARow(x, i) > e) {
                    sumOfRowMoreThanE = sumOfRowMoreThanE - memberOfARow(x, i);
                }
                if (memberOfARow(x, i) > e / 10) {
                    sumOfRowETen = sumOfRowETen - memberOfARow(x, i);
                }
            }

        }
        System.out.printf("1) Sum of n members of a row: %s\n", sumOfRowN);
        System.out.printf("2) Sum of n members of a row, which in absolute value exceed e: %s\n", sumOfRowMoreThanE);
        System.out.printf("3) Sum of n members of a row, which in absolute value exceed e/10: %s\n", sumOfRowETen);
    }

    private static double memberOfARow(double x, int n) {
        return Math.pow(x, 2 * n) / countFactorial(2 * n);
    }

    private static double countFactorial(double numberForFactorial) {
        double factorial = 1;
        for (int i = 1; i <= numberForFactorial; i++) {
            factorial = factorial * i;
        }
        return factorial;
    }
}
