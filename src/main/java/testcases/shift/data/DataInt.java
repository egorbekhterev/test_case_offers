package testcases.shift.data;

import testcases.shift.io.FileReadingInt;
import testcases.shift.io.Input;

import java.io.IOException;
import java.util.List;

public class DataInt implements Data<Integer> {

    @Override
    public Integer[] insert() throws IOException {
        Input<Integer> fR = new FileReadingInt("./src/main/java/testcases/files/in");
        List<Integer> integerList = fR.readFile();
        return integerList.toArray(new Integer[0]);
    }
}
