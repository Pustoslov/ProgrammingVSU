package vsu.pustoslov.task10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class OutputFileWriterTablets {
    public void saveFile(String outputFile, Tablet bestTablet, int quantityOfTablets)
            throws FileNotFoundException {
        final File file = new File(outputFile);
        final PrintWriter write = new PrintWriter(file);

        if (bestTablet == null) {
            write.print("No suitable tablet found, sorry");
        } else {
            write.print("Best choice for you is\nName: " + bestTablet.getName() + "\nMemory size: " +
                    bestTablet.getMemory() + "\nUsers rate: " + bestTablet.getRate() + "\nPrice per one: "
                    + bestTablet.getPrice() + "\nTotal price for " + quantityOfTablets + " tablets = " +
                    bestTablet.getPrice() * quantityOfTablets);
        }

        write.close();
    }
}