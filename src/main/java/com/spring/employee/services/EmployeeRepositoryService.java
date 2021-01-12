package com.spring.employee.services;

import com.spring.employee.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepositoryService {

    Employee save(Employee employee);

    List<Employee> getAllEmployees();

    Optional<Employee> getEmployee(Long employeeId);

    void delete(Employee employee);
}
