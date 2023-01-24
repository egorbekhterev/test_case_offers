package testcases.shift.output;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWritingString implements Output<String> {

    private final String outputPath;

    public FileWritingString(String outputPath) {
        this.outputPath = outputPath;
    }

    @Override
    public void printFile(String[] array) {
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(outputPath)
                ))) {
            for (String s : array) {
                printWriter.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
