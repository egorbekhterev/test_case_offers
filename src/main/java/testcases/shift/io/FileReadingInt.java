package testcases.shift.io;

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

    private final String inputPath;

    public FileReadingInt(String inputPath) {
        this.inputPath = inputPath;
    }

    @Override
    public List<Integer> readFile() throws IOException {
        List<Integer> list = new ArrayList<>();
        List<File> filesInFolder = Files.walk(Paths.get(inputPath))
                .filter(Files::isRegularFile)
                .map(Path::toFile).toList();
        for (File file : filesInFolder) {
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                in.lines()
                        .filter(s -> !s.contains(" "))
                        .map(Integer::parseInt)
                        .forEach(list::add);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
