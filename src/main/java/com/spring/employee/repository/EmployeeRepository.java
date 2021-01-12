package com.spring.employee.repository;

import com.spring.employee.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long>
{
    Employee save(Employee employee);

    List<Employee> findAll();

    Optional<Employee> findById(Long employeeId);

    void delete(Employee employee);
}
