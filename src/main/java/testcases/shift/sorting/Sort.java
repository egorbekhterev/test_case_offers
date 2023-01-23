package testcases.shift.sorting;

import java.io.IOException;

public interface Sort<T> {
    T[] sort(T[] array) throws IOException;
}
