package testcases.shift;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import testcases.shift.validation.Args;

import java.io.*;
import java.nio.file.Path;

import static org.assertj.core.api.Assertions.*;

class MainTest {

    @Test
    void whenIntegerAscSort(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("1");
            out.println("4");
            out.println("9");
        }
        File target  = tempDir.resolve("target.txt").toFile();
        Args args = new Args();
        String[] strArgs = {"-a", "-i", target.getAbsolutePath(), source.getAbsolutePath()};
        args.accomplish(strArgs);
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat("149").isEqualTo(rsl.toString());
    }

    @Test
    void whenIntegerDescSort(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("1");
            out.println("4");
            out.println("9");
        }
        File target  = tempDir.resolve("target.txt").toFile();
        Args args = new Args();
        String[] strArgs = {"-d", "-i", target.getAbsolutePath(), source.getAbsolutePath()};
        args.accomplish(strArgs);
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat("941").isEqualTo(rsl.toString());
    }

    @Test
    void whenStringAscSort(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("a");
            out.println("b");
            out.println("c");
        }
        File target  = tempDir.resolve("target.txt").toFile();
        Args args = new Args();
        String[] strArgs = {"-a", "-s", target.getAbsolutePath(), source.getAbsolutePath()};
        args.accomplish(strArgs);
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat("abc").isEqualTo(rsl.toString());
    }

    @Test
    void whenStringDescSort(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("a");
            out.println("b");
            out.println("c");
        }
        File target  = tempDir.resolve("target.txt").toFile();
        Args args = new Args();
        String[] strArgs = {"-d", "-s", target.getAbsolutePath(), source.getAbsolutePath()};
        args.accomplish(strArgs);
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat("cba").isEqualTo(rsl.toString());
    }

    @Test
    void whenSourceHasBlankLine(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("    ");
            out.println("b");
            out.println("c");
        }
        File target  = tempDir.resolve("target.txt").toFile();
        Args args = new Args();
        String[] strArgs = {"-a", "-s", target.getAbsolutePath(), source.getAbsolutePath()};
        args.accomplish(strArgs);
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat("bc").isEqualTo(rsl.toString());
    }

    @Test
    void whenSourceHasWhitespaces(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("a      ");
            out.println("b");
            out.println("c");
        }
        File target  = tempDir.resolve("target.txt").toFile();
        Args args = new Args();
        String[] strArgs = {"-a", "-s", target.getAbsolutePath(), source.getAbsolutePath()};
        args.accomplish(strArgs);
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat("bc").isEqualTo(rsl.toString());
    }

    @Test
    void whenIntegerSortWithNotIntNumbersInLines(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("1   aaaa");
            out.println("d 2");
            out.println("3");
        }
        File target  = tempDir.resolve("target.txt").toFile();
        Args args = new Args();
        String[] strArgs = {"-a", "-i", target.getAbsolutePath(), source.getAbsolutePath()};
        args.accomplish(strArgs);
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
        }
        assertThat("3").isEqualTo(rsl.toString());
    }

    @Test
    void whenLessThanTwoTxtFilesInTheParameters(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("1");
            out.println("4");
            out.println("9");
        }
        Args args = new Args();
        String[] strArgs = {"-a", "-i", source.getAbsolutePath()};
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> args.accomplish(strArgs))
                .withMessageContaining("To run the application you need to specify");
    }

    @Test
    void whenLessThanThreeArguments(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("1");
            out.println("4");
            out.println("9");
        }
        File target  = tempDir.resolve("target.txt").toFile();
        Args args = new Args();
        String[] strArgs = {source.getAbsolutePath(), target.getAbsolutePath()};
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> args.accomplish(strArgs))
                .withMessageContaining("Insufficient number of parameters to");
    }

    @Test
    void whenTypeArgumentStartsWithoutMinus(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("1");
            out.println("4");
            out.println("9");
        }
        File target  = tempDir.resolve("target.txt").toFile();
        Args args = new Args();
        String[] strArgs = {"i", source.getAbsolutePath(), target.getAbsolutePath()};
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> args.accomplish(strArgs))
                .withMessageContaining("Sorting mode and data type must start with \"-\"");
    }

    @Test
    void whenFileArgumentHasNonTxtFormat(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.png").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("1");
            out.println("4");
            out.println("9");
        }
        File target  = tempDir.resolve("target.txt").toFile();
        Args args = new Args();
        String[] strArgs = {"i", source.getAbsolutePath(), target.getAbsolutePath()};
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> args.accomplish(strArgs))
                .withMessageContaining("Sorting mode and data type must start with \"-\"");
    }

    @Test
    void whenTypeArgumentIsUnacceptable(@TempDir Path tempDir) throws IOException {
        File source = tempDir.resolve("source.txt").toFile();
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("1");
            out.println("4");
            out.println("9");
        }
        File target  = tempDir.resolve("target.txt").toFile();
        Args args = new Args();
        String[] strArgs = {"-k", source.getAbsolutePath(), target.getAbsolutePath()};
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> args.accomplish(strArgs))
                .withMessageContaining("Sorting mode and data type must consist of:");
    }
}
