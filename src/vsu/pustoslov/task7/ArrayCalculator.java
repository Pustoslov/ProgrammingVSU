package vsu.pustoslov.task7;

public class ArrayCalculator {
    public int calculateAnswer(int[] array) {
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