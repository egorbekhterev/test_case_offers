package testcases.shift.input;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReadingString implements Input<String> {

    private final List<String> inputPath;

    public FileReadingString(List<String> inputPath) {
        this.inputPath = inputPath;
    }

    @Override
    public String[] readFile() {
        List<String> list = new ArrayList<>();
        List<File> filesInFolder = new ArrayList<>();
        for (String input : inputPath) {
            filesInFolder.add(new File(input));
        }
        for (File file : filesInFolder) {
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                in.lines()
                        .filter(s -> !s.isBlank() && !s.contains(" "))
                        .forEach(list::add);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list.toArray(new String[0]);
    }
}
