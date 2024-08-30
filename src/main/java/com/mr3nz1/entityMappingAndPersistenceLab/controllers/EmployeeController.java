package com.mr3nz1.entityMappingAndPersistenceLab.controllers;

import com.mr3nz1.entityMappingAndPersistenceLab.models.Employee;
import com.mr3nz1.entityMappingAndPersistenceLab.services.EmployeeService;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @PostMapping("/add")
    public Employee add() {
        return employeeService
                .addEmployee(
                        Employee
                                .builder()
                                .firstName("John")
                                .surname("Doe")
                                .telephone("07885202342")
                                .address("Rubavu")
                                .build()
                );
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable ObjectId id) throws Exception {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/all")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
}
