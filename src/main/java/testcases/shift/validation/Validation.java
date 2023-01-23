package testcases.shift.validation;

import java.io.IOException;

public interface Validation {
    void validate(String[] args);

    void accomplish(String[] args) throws IOException;
}
