package sky.pro.employee;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Employee[] employees;
    private int size;

    public EmployeeServiceImpl() {
        employees = new Employee[10];
    }

    public EmployeeServiceImpl(Employee[] employees, int size) {
        this.employees = employees;
        this.size = size;
    }

    public Employee add(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (size == employees.length) {
            throw new EmployeeOverflowException();
        }
        int index = indexOf(employee);
        if (index != -1) {
            throw new EmployeeNotExistsException();
        }
        employees[size++] = employee;
        return employee;
    }

    public Employee delete(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        int index = indexOf(employee);
        if (index != -1) {
            Employee result = employees[index];
            System.arraycopy(employees, index = 1, employees, index, size - index);
            size--;
            return result;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee find(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        int index = indexOf(employee);
        if (index != -1) {
            return employees[index];
        }
        throw new EmployeeNotFoundException();
    }

    private int indexOf(Employee employee) {
        for (int i = 0; i < size; i++) {
            if (employees[i].equals(employee)) {
                return i;
            }
        }
        return -1;
    }
}
