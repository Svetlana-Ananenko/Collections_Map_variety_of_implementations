


import com.ollection.hw.exceptions.EmployeeNotFoundException;
import exception.EmployeeAlreadyAddedException;


import java.util.*;


public class EmployeeService implements com.ollection.hw.EmployeeServiceInterface {

    private final Map<String, com.ollection.hw.Employee> employeeMap;


    public EmployeeService() {
        this.employeeMap = new HashMap<>(Map.of());
    }


    int maxEmployee = 2;

    public String first() {
        return "<b> Пока у нас один сотрудник и это Алексей Кестнер </b> ";
    }


    @Override
    public com.ollection.hw.Employee add(String firstName, String lastName) {
        com.ollection.hw.Employee employee = new com.ollection.hw.Employee(firstName, lastName);
        if (employeeMap.containsKey(employee.getFirstNameAndLastName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employeeMap.put(employee.getFirstNameAndLastName(), employee);
        return employee;
    }


    @Override
    public com.ollection.hw.Employee remove(String firstName, String lastName) {
        com.ollection.hw.Employee employee = new com.ollection.hw.Employee(firstName, lastName);

        if (employeeMap.containsKey(employee.getFirstNameAndLastName())) {
            return employeeMap.remove(employee.getFirstNameAndLastName());
        }
        throw new EmployeeNotFoundException();
    }


    @Override
    public com.ollection.hw.Employee find(String firstName, String lastName) {
        com.ollection.hw.Employee employee = new com.ollection.hw.Employee(firstName, lastName);

        if (!employeeMap.containsKey(employee.getFirstNameAndLastName())) {
            throw new EmployeeNotFoundException();
        }
        return employeeMap.get(employee.getFirstNameAndLastName());
    }

    @Override
    public Collection<com.ollection.hw.Employee> findAll() {
        return Collections.unmodifiableCollection(employeeMap.values());
    }
}
