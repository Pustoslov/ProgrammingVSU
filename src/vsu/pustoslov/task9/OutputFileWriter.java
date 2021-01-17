package vsu.pustoslov.task9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class OutputFileWriter {
    public void saveFile(List<Integer> answerList, String outputFile) throws FileNotFoundException {
        final File file = new File(outputFile);
        try (final PrintWriter writer = new PrintWriter(file)) {
            for (Integer value : answerList) {
                if (!value.equals(answerList.get(answerList.size() - 1))) {
                    writer.print(value + ", ");
                } else {
                    writer.print(value);
                }
            }
        }
    }
}
