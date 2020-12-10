package vsu.pustoslov.task8;

import java.io.Console;
import java.io.FileNotFoundException;
import ru.vsu.cs.util.ArrayUtils;

public class Task8CMD {
    private static final Console CONSOLE = System.console();

    public static void main(String[] args) throws FileNotFoundException {
        if (CONSOLE == null) {
            return;
        }

        final String inputFileName = CONSOLE.readLine("\n");
        int[][] array = ArrayUtils.readIntArray2FromFile(inputFileName);

        final MatrixCut matrixCut = new MatrixCut();
        array = matrixCut.trimMatrixToSquare(array);

        String outputFileName = CONSOLE.readLine("\n");

        if (!outputFileName.toLowerCase().endsWith(".txt")) {
            outputFileName += ".txt";
        }
        ArrayUtils.writeArrayToFile(outputFileName, array);
    }
}
