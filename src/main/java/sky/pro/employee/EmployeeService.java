package sky.pro.employee;

public interface EmployeeService {

    Employee add(String firstName, String lastName);

    Employee delete(String firstName, String lastName);

    Employee find(String firstName, String lastName);

}
