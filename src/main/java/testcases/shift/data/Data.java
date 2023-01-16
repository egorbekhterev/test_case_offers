package testcases.shift.data;

import java.io.IOException;

public interface Data<T> {
    T[] insert() throws IOException;
}
