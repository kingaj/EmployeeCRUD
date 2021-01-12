package com.spring.employee.services.impl;

import com.spring.employee.model.Employee;
import com.spring.employee.services.EmployeeRepositoryService;
import com.spring.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeRepositoryService employeeRepositoryService;

    @Override
    public Employee save(Employee employee) {
        return employeeRepositoryService.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepositoryService.getAllEmployees();
    }

    @Override
    public Optional<Employee> getEmployee(Long employeeId) {
        return employeeRepositoryService.getEmployee(employeeId);
    }

    @Override
    public void delete(Employee employee) {
        employeeRepositoryService.delete(employee);
    }
}
