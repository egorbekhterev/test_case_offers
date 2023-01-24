package testcases.shift.output;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWritingInt implements Output<Integer> {

    private final String outputPath;

    public FileWritingInt(String outputPath) {
        this.outputPath = outputPath;
    }

    @Override
    public void printFile(Integer[] array) {
        try (PrintWriter printWriter = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(outputPath)
                ))) {
            for (Integer i : array) {
                printWriter.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
