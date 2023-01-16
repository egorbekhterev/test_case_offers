package testcases.shift.io;

import java.io.IOException;
import java.util.List;

public interface Input<T> {
    List<T> readFile() throws IOException;
}
