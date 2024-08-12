import exception.EmployeeAlreadyAddedException;
import exception.EmployeeStorageIsFullException;

@RestController
@RequestMapping
public class EmployeeController {

    private final com.ollection.hw.EmployeeService employeeService;
    private String firstName;
    private String lastName;

    public EmployeeController(com.ollection.hw.EmployeeService employeeService) {
        this.employeeService = employeeService;
    }




    @GetMapping(path = "/employee/add")
    public com.ollection.hw.Employee add(@RequestParam("firstName") String firstName,
                                         @RequestParam("lastName") String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        try {
            employeeService.add(firstName, lastName);
        } catch (EmployeeAlreadyAddedException r) {
            System.out.println("В коллекции уже есть такой сотрудник");
        } catch (EmployeeStorageIsFullException e) {
            System.out.println("Превышен лимит количества сотрудников в фирме");
        }
        return employeeService.add(firstName, lastName);


    }


    @GetMapping(path = "/employee/remove")
    public com.ollection.hw.Employee remove(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            employeeService.remove(firstName, lastName);
        } catch (com.ollection.hw.exceptions.EmployeeNotFoundException e) {
            System.out.println("Сотрудник не найден");
        }
        return employeeService.remove(firstName, lastName);
    }


    @GetMapping(path = "/employee/find")
    public com.ollection.hw.Employee find(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        try {
            employeeService.find(firstName, lastName);

        } catch (EmployeeNotFoundException e) {
            System.out.println("Сотрудник не найден");
        }

        return employeeService.find(firstName, lastName);
    }


    @GetMapping(path = "/employee")
    public Collection <com.ollection.hw.Employee> findAll  () {
        return employeeService.findAll();
    }




}
