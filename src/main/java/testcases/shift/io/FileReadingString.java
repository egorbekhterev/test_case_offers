package testcases.shift.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReadingString implements Input<String> {

    private final String inputPath;

    public FileReadingString(String inputPath) {
        this.inputPath = inputPath;
    }

    @Override
    public List<String> readFile() throws IOException {
        List<String> list = new ArrayList<>();
        List<File> filesInFolder = Files.walk(Paths.get(inputPath))
                .filter(Files::isRegularFile)
                .map(Path::toFile).toList();
        for (File file : filesInFolder) {
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                in.lines()
                        .filter(s -> !s.contains(" "))
                        .forEach(list::add);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
