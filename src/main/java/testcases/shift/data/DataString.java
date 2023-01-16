package testcases.shift.data;

import testcases.shift.io.FileReadingString;
import testcases.shift.io.Input;

import java.io.IOException;
import java.util.List;

public class DataString implements Data<String> {

    @Override
    public String[] insert() throws IOException {
        Input<String> fR = new FileReadingString("./src/main/java/testcases/files/in");
        List<String> stringList = fR.readFile();
        return stringList.toArray(new String[0]);
    }
}
