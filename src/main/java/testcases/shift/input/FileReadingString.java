package testcases.shift.input;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReadingString implements Input<String> {

    private final List<String> inputPath;

    public FileReadingString(List<String> inputPath) {
        this.inputPath = inputPath;
    }

    @Override
    public String[] readFile() throws IOException {
        List<String> list = new ArrayList<>();
        List<File> filesInFolder = Files.walk(Paths.get("./src/main/java/testcases/shift/files/in/"))
                .filter(Files::isRegularFile)
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
                        .forEach(list::add);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list.toArray(new String[0]);
    }
}
