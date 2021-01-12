package com.spring.employee.services.impl;

import com.spring.employee.model.Employee;
import com.spring.employee.repository.EmployeeRepository;
import com.spring.employee.services.EmployeeRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeRepositoryServiceImpl implements EmployeeRepositoryService
{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployee(Long employeeId) {
        return employeeRepository.findById(employeeId);
    }


    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }
}
