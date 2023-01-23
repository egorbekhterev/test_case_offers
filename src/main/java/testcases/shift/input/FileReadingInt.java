package testcases.shift.input;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReadingInt implements Input<Integer> {

    private final List<String> inputPath;

    public FileReadingInt(List<String> inputPath) {
        this.inputPath = inputPath;
    }

    @Override
    public Integer[] readFile() throws IOException {
        List<Integer> list = new ArrayList<>();
        List<File> filesInFolder = Files.walk(
                Paths.get("./src/main/java/testcases/shift/files/in/"))
                .filter(Files::isRegularFile)
                .distinct()
                .map(Path::toFile)
                .filter(file -> {
                    boolean rsl = false;
                    for (String input : inputPath) {
                        if (file.getName().matches(input)) {
                            rsl = true;
                        }
                    }
                    return rsl;
                })
                .toList();
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
