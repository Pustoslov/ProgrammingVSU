package vsu.pustoslov.task8;

public class MatrixCut {
    public int[][] trimMatrixToSquare(int[][] matrix) {
        final int rowLength = matrix[0].length;
        final int columnLength = matrix.length;
        return (rowLength <= columnLength ? trimMatrix(rowLength, matrix) : trimMatrix(columnLength, matrix));
    }

    private static int[][] trimMatrix(int sideOfASquare, int[][] matrix) {
        int[][] answerMatrix = new int[sideOfASquare][sideOfASquare];
        for (int i = 0; i < sideOfASquare; i++) {
            System.arraycopy(matrix[i], 0, answerMatrix[i], 0, sideOfASquare);
        }
        return answerMatrix;
    }
}
