package sky.pro.employee;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class EmployeeOverflowException extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "Employee is full";

    public EmployeeOverflowException() {
        super(DEFAULT_MESSAGE);
    }
}
