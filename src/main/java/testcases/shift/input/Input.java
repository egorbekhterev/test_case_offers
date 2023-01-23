package testcases.shift.input;

import java.io.IOException;

public interface Input<T> {
    T[] readFile() throws IOException;
}
