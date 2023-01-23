package testcases.shift.validation;

import testcases.shift.input.*;
import testcases.shift.output.FileWritingInt;
import testcases.shift.output.FileWritingString;
import testcases.shift.output.Output;
import testcases.shift.sorting.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Args implements Validation {

    private int count = 0;

    @Override
    public void validate(String[] args) {
        if (args.length < 2) {
            throw new IllegalArgumentException("Insufficient number of parameters to "
                    + "realize the program, there should be at least 3 parameters.");
        }
        for (String arg : args) {
            if (!arg.startsWith("-") && !arg.matches(".*\\.txt")) {
                throw new IllegalArgumentException(String.format(
                        "Sorting mode and data type must start with \"-\" and "
                                + "file names must have an extension at the end: %s", arg
                ));
            }
            if ((!arg.matches("-a") && !arg.matches("-d"))
                    && (!arg.matches("-i") && !arg.matches("-s")) && !arg.matches(".*\\.txt")) {
                throw new IllegalArgumentException(String.format(
                        "Sorting mode and data type must consist of: "
                                + "\"-a\" as ASC(optional); \"-d\" as DESC; \"i\" as Integer; "
                                + "\"s\" as String. Fault point: %s", arg
                ));
            }
            if (arg.matches(".*\\.txt")) {
                count++;
            }
        }
        if (count < 2) {
            throw new IllegalArgumentException("To run the application you need to specify output file "
                    + "and input file in the parameters.");
        }
    }

    @Override
    public void accomplish(String[] args) throws IOException {
        validate(args);
        List<String> list = new ArrayList<>();
        List<String> txt = new ArrayList<>();
        for (String arg : args) {
            if (arg.startsWith("-")) {
                list.add(arg);
            } else {
                txt.add(arg);
            }
        }
        if (list.contains("-s")) {
            Input<String> stringInput = new FileReadingString(txt.subList(1, txt.size()));
            Sort<String> stringSort = new MergeSortStringAsc();
            var array = stringSort.sort(stringInput.readFile());
            Output<String> stringOutput = new FileWritingString(txt.get(0));
            stringOutput.printFile(array);
        }
        if (list.contains("-i")) {
            Input<Integer> integerInput = new FileReadingInt(txt.subList(1, txt.size()));
            Sort<Integer> integerSort = new MergeSortIntAsc();
            var array = integerSort.sort(integerInput.readFile());
            Output<Integer> integerOutput = new FileWritingInt(txt.get(0));
            integerOutput.printFile(array);
        }
        if (list.contains("-d") && list.contains("-s")) {
            Input<String> stringInput = new FileReadingString(txt.subList(1, txt.size()));
            Sort<String> stringSort = new MergeSortStringDesc();
            var array = stringSort.sort(stringInput.readFile());
            Output<String> stringOutput = new FileWritingString(txt.get(0));
            stringOutput.printFile(array);
        }
        if (list.contains("-d") && list.contains("-i")) {
            Input<Integer> integerInput = new FileReadingInt(txt.subList(1, txt.size()));
            Sort<Integer> integerSort = new MergeSortIntDesc();
            var array = integerSort.sort(integerInput.readFile());
            Output<Integer> integerOutput = new FileWritingInt(txt.get(0));
            integerOutput.printFile(array);
        }
    }
}
