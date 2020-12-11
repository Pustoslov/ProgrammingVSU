package vsu.pustoslov.task9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class OutputFileWriter {
    public static void saveFile(List<Integer> answerList, String outputFile) throws FileNotFoundException {
        final File file = new File(outputFile);
        final PrintWriter write = new PrintWriter(file);
        for (Integer value : answerList) {
            if (!value.equals(answerList.get(answerList.size() - 1))) {
                write.print(value + ", ");
            } else {
                write.print(value);
            }
        }
        write.close();
    }
}
