package dev.alfrendosilalahi.qbe;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // find all employees matching exact criteria
    public List<Employee> findEmployeesByExample(Employee employee) {
        Example<Employee> example = Example.of(employee);
        return employeeRepository.findAll(example);
    }

    // find all employees by firstName and department
    public List<Employee> findAllEmployeesByFirstNameAndDepartment(String firstName, String department) {
        var employee = new Employee();
        employee.setFirstName(firstName);
        employee.setDepartment(department);

        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnoreCase() // ignore case for all string matches
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING) // use like %values% for strings
                .withIgnoreNullValues() // ignore null values
                .withMatcher("firstName", ExampleMatcher.GenericPropertyMatcher::exact) // firstName exact match
                .withMatcher("department", ExampleMatcher.GenericPropertyMatcher::contains); // department can be partial

        Example<Employee> example = Example.of(employee, exampleMatcher);
        return employeeRepository.findAll(example);
    }

}
