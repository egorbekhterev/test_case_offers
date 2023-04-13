package leetcode;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class WordQuantity {
    public static void main(String[] args) throws IOException {
        var searchWord = args[0];
        long count = Files.lines(Paths.get("words.txt"))
                .flatMap(s -> Stream.of(s.split("\\s+")))
                .map(String::toString)
                .filter(word -> word.equals(searchWord))
                .count();
        System.out.println(count);
    }
}
