package testcases.shift.sorting;

import testcases.shift.data.Data;

import java.io.IOException;

public interface Sort<T> {
    T[] sort(Data<T> data) throws IOException;
}
