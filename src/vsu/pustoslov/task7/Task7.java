package vsu.pustoslov.task7;

import ru.vsu.cs.util.ArrayUtils;

import java.util.Arrays;

public class Task7 {
    private static final int[][] ARRAY_FOR_TESTS = {
            {1, 2, 3, 4, 5, 6, 7, 8, 9, 10},
            {0, -1, -2, -3, -4, -5, -6, -7, -8, -9},
            {0, 0, -2, 2, -4, 4},
            {0, 0, 0, 0, 0, 0, 0},
            {2, 2, 2, 2, 2, 2, 2, 2},
            {-15, -15, -15},
            {4, 4, 4, 235},
            {1, -7, -7, -7, -7, -7},
            {14, 45},
            {564},
            {-21},
            {0},
    };

    public static void main(String[] args) {
        for (int[] row : ARRAY_FOR_TESTS) {
            System.out.printf("For array %s with length = %s\n answer = %s\n", Arrays.toString(row), row.length, calculateAnswer(row));
        }

        try {
            final int[] array = ArrayUtils.readIntArrayFromConsole();
            System.out.printf("Answer = %s\n", calculateAnswer(array));
        } catch (Exception e) {
            System.out.println("Enter non-empty array please!");
            final int[] array = ArrayUtils.readIntArrayFromConsole();
            System.out.printf("Answer = %s\n", calculateAnswer(array));
        }
    }

    private static int calculateAnswer(int[] array) {
        int amountOfElementsToFind = 0;
        int min = array[0];
        int counterOfIdenticalNumbers = 1;

        for (int i = 1; i < array.length; i++) {
            if (array[i - 1] == array[i]) {
                counterOfIdenticalNumbers++;
            }

            if (array[i] < min) {
                min = array[i];
            }
        }

        if (counterOfIdenticalNumbers == array.length) {
            return 0;
        }

        final double arrayAverage = calculateArrayAverageGreaterThanMin(array, min);

        for (int currentValue : array) {
            if (currentValue >= arrayAverage) {
                amountOfElementsToFind++;
            }
        }

        return amountOfElementsToFind;
    }

    private static double calculateArrayAverageGreaterThanMin(int[] array, int min) {
        int amountOfDigits = 0;
        double sumOfArrayElements = 0;

        for (int currentValue : array) {
            if (currentValue > min) {
                sumOfArrayElements += currentValue;
                amountOfDigits++;
            }
        }

        return sumOfArrayElements / amountOfDigits;
    }

}
