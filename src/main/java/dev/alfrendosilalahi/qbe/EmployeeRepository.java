package dev.alfrendosilalahi.qbe;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long>, QueryByExampleExecutor<Employee> {

    List<Employee> findAllByFirstName(String firstName);

    @Query("SELECT Employee FROM Employee e WHERE e.firstName = ?1 AND e.lastName = ?2")
    List<Employee> findAllByFirstNameAndLastName(String firstName, String lastName);

}
