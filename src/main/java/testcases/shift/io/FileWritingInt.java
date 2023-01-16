package testcases.shift.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWritingInt implements Output<Integer> {

    @Override
    public void printFile(Integer[] array) {
        try (PrintWriter printWriter = new PrintWriter(new FileOutputStream("./src/main/java/testcases/files/out/out.txt"))){
            for (Integer i : array) {
                printWriter.println(i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
