package testcases.shift.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWritingString implements Output<String> {

    @Override
    public void printFile(String[] array) {
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream("./src/main/java/testcases/files/out/out.txt"))){
            for (String s : array) {
                printWriter.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
