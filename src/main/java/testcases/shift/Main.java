package testcases.shift;

import testcases.shift.data.Data;
import testcases.shift.data.DataInt;
import testcases.shift.io.*;
import testcases.shift.sorting.MergeSortIntDesc;
import testcases.shift.sorting.Sort;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Data<Integer> data = new DataInt();
        Sort<Integer> sort = new MergeSortIntDesc();
        Integer[] sortedArray = sort.sort(data);
        Output<Integer> output = new FileWritingInt();
        output.printFile(sortedArray);
    }
}
