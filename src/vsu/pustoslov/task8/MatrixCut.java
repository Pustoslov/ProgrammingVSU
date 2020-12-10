package vsu.pustoslov.task8;

public class MatrixCut {

    public int[][] trimMatrixToSquare(int[][] matrix) {
        final int columnLength = matrix.length;
        final int maxLengthOfRow = countMaxLengthOfRow(columnLength, matrix);
        final int[][] rectangleMatrix = turnRandomArrayToRectangle(columnLength, maxLengthOfRow, matrix);
        return (maxLengthOfRow <= columnLength ? trimMatrix(maxLengthOfRow, rectangleMatrix)
                : trimMatrix(columnLength, rectangleMatrix));
    }

    private static int[][] trimMatrix(int sideOfASquare, int[][] matrix) {
        int[][] answerMatrix = new int[sideOfASquare][sideOfASquare];
        for (int i = 0; i < sideOfASquare; i++) {
            System.arraycopy(matrix[i], 0, answerMatrix[i], 0, sideOfASquare);
        }
        return answerMatrix;
    }

    private static int countMaxLengthOfRow(int columnLength, int[][] matrix) {
        int maxLengthOfRow = 0;
        for (int i = 0; i < columnLength; i++) {
            if (matrix[i].length > maxLengthOfRow) {
                maxLengthOfRow = matrix[i].length;
            }
        }
        return maxLengthOfRow;
    }

    private static int[][] turnRandomArrayToRectangle(int columnLength, int maxLengthOfRow, int[][] matrix) {
        final int[][] rectangleMatrix = new int[columnLength][maxLengthOfRow];
        for (int i = 0; i < columnLength; i++) {
            System.arraycopy(matrix[i], 0, rectangleMatrix[i], 0, matrix[i].length);
        }
        return rectangleMatrix;
    }
}
