package dev.alfrendosilalahi.qbe;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public List<Employee> findAllEmployeeByExample(@RequestBody Employee employee) {
        return employeeService.findEmployeesByExample(employee);
    }

    @GetMapping
    public List<Employee> findAllEmployeesByFirstNameAndDepartment(
            @RequestParam String firstName,
            @RequestParam String department
    ) {
        return employeeService.findAllEmployeesByFirstNameAndDepartment(firstName, department);
    }

}
