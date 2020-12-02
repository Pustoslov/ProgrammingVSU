package vsu.pustoslov.task8;

import java.io.Console;
import java.io.FileNotFoundException;
import ru.vsu.cs.util.ArrayUtils;

public class Task8CMD {
    public static final Console CONSOLE = System.console();

    public static void main(String[] args) throws FileNotFoundException {
        if (CONSOLE != null) {
            final String inputFileName = CONSOLE.readLine();
            final int[][] arr = ArrayUtils.readIntArray2FromFile(inputFileName);
            final MatrixCut matrixCut = new MatrixCut();
            final int[][] matrix = matrixCut.trimMatrixToSquare(arr);
            String outputFileName = CONSOLE.readLine();
            if (!outputFileName.toLowerCase().endsWith(".txt")) {
                outputFileName += ".txt";
            }
            ArrayUtils.writeArrayToFile(outputFileName, matrix);
        }
    }
}
