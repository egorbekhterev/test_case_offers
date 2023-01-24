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
        if (args.length < 3) {
            throw new IllegalArgumentException(String.format("Insufficient number of parameters to "
                    + "realize the program, there should be at least 3 parameters. "
                    + "Current args length: %s", args.length));
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
        List<String> typeArguments = new ArrayList<>();
        List<String> fileTxtArguments = new ArrayList<>();
        for (String arg : args) {
            if (arg.startsWith("-") && arg.length() == 2) {
                typeArguments.add(arg);
            } else {
                fileTxtArguments.add(arg);
            }
        }
        if (typeArguments.contains("-s")) {
            Input<String> stringInput = new FileReadingString(fileTxtArguments.subList(1, fileTxtArguments.size()));
            Sort<String> stringSort = new MergeSortStringAsc();
            var array = stringSort.sort(stringInput.readFile());
            Output<String> stringOutput = new FileWritingString(fileTxtArguments.get(0));
            stringOutput.printFile(array);
        }
        if (typeArguments.contains("-i")) {
            Input<Integer> integerInput = new FileReadingInt(fileTxtArguments.subList(1, fileTxtArguments.size()));
            Sort<Integer> integerSort = new MergeSortIntAsc();
            var array = integerSort.sort(integerInput.readFile());
            Output<Integer> integerOutput = new FileWritingInt(fileTxtArguments.get(0));
            integerOutput.printFile(array);
        }
        if (typeArguments.contains("-d") && typeArguments.contains("-s")) {
            Input<String> stringInput = new FileReadingString(fileTxtArguments.subList(1, fileTxtArguments.size()));
            Sort<String> stringSort = new MergeSortStringDesc();
            var array = stringSort.sort(stringInput.readFile());
            Output<String> stringOutput = new FileWritingString(fileTxtArguments.get(0));
            stringOutput.printFile(array);
        }
        if (typeArguments.contains("-d") && typeArguments.contains("-i")) {
            Input<Integer> integerInput = new FileReadingInt(fileTxtArguments.subList(1, fileTxtArguments.size()));
            Sort<Integer> integerSort = new MergeSortIntDesc();
            var array = integerSort.sort(integerInput.readFile());
            Output<Integer> integerOutput = new FileWritingInt(fileTxtArguments.get(0));
            integerOutput.printFile(array);
        }
    }
}
