package vsu.pustoslov.task8;

public class Logic {
    public int[][] calculateAnswer(int[][] matrix) {
        final int rowLength = matrix[0].length;
        final int columnLength = matrix.length;

        if (rowLength <= columnLength) {
            int[][] answerMatrix = new int[rowLength][rowLength];
            for (int i = 0; i < rowLength; i++) {
                System.arraycopy(matrix[i], 0, answerMatrix[i], 0, rowLength);
            }
            return answerMatrix;
        }

        int[][] answerMatrix = new int[columnLength][columnLength];
        for (int i = 0; i < columnLength; i++) {
            System.arraycopy(matrix[i], 0, answerMatrix[i], 0, columnLength);
        }
        return answerMatrix;
    }
}
