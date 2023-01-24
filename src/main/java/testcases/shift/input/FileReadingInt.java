package testcases.shift.input;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReadingInt implements Input<Integer> {

    private final List<String> inputPath;

    public FileReadingInt(List<String> inputPath) {
        this.inputPath = inputPath;
    }

    @Override
    public Integer[] readFile() {
        List<Integer> list = new ArrayList<>();
        List<File> filesInFolder = new ArrayList<>();
        for (String input : inputPath) {
                filesInFolder.add(new File(input));
        }
        for (File file : filesInFolder) {
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                in.lines()
                        .filter(s -> !s.isBlank() && !s.contains(" "))
                        .filter(s -> s.matches("[0-9]+"))
                        .map(Integer::parseInt)
                        .forEach(list::add);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list.toArray(new Integer[0]);
    }
}
