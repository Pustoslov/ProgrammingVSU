package vsu.pustoslov.task7;

import vsu.pustoslov.commons.ConsoleReader;

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
        final ConsoleReader consoleReader = new ConsoleReader();
        final ArrayCalculator arrayCalculator = new ArrayCalculator();

        for (int[] row : ARRAY_FOR_TESTS) {
            System.out.printf("For array %s with length = %s\n answer = %s\n", Arrays.toString(row),
                    row.length, arrayCalculator.calculateAnswer(row));
        }

        final int[] consoleArray = consoleReader.readIntArray();
        System.out.printf("Answer = %s\n", arrayCalculator.calculateAnswer(consoleArray));
    }
}