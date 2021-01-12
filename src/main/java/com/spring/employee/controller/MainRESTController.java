package com.spring.employee.controller;

import java.util.List;

import com.spring.employee.exception.ResourceNotFoundException;
import com.spring.employee.model.Employee;
import com.spring.employee.services.EmployeeService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MainRESTController {

    @Autowired
    private EmployeeService employeeService;

    private static final Logger logger = LogManager.getLogger(MainRESTController.class);

    @RequestMapping("/")
    @ResponseBody
    public String welcome() {
        return "Welcome to Employee CRUD<b> Develop By Ajay.</b>";
    }

    @RequestMapping(value = "/employees",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public List<Employee> getEmployees() {
        logger.debug("get all employee request");
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/employee/{id}",
            method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee getEmployee(@PathVariable("id") String id) {
        return employeeService.getEmployee(Long.parseLong(id)).orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
    }

    @RequestMapping(value = "/employee",
            method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee addEmployee(@RequestBody Employee emp) {

        logger.debug("save employee request");

        return employeeService.save(emp);
    }

    @RequestMapping(value = "/employee",
            method = RequestMethod.PUT,
            produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public Employee updateEmployee(@RequestBody Employee emp) {
        logger.debug("update employee request");
        Employee employee = employeeService.getEmployee(emp.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", emp.getId()));
        employee.setFirstName(emp.getFirstName());
        employee.setLastName(emp.getLastName());
        employee.setEmail(emp.getEmail());
        employee.setAge(emp.getAge());
        employee.setGender(emp.getGender());
        employee.setAddress(emp.getAddress());

        return employeeService.save(emp);
    }

    @RequestMapping(value = "/employee/{id}",
            method = RequestMethod.DELETE,
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    @ResponseBody
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") String id) {
        logger.debug("delete employee request");

        Employee employee = employeeService.getEmployee(Long.parseLong(id))
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        employeeService.delete(employee);

        return ResponseEntity.ok().build();
    }

}
