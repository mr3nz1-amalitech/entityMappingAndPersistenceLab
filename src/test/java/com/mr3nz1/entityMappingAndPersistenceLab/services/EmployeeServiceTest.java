package com.mr3nz1.entityMappingAndPersistenceLab.services;

import com.mr3nz1.entityMappingAndPersistenceLab.models.Employee;
import com.mr3nz1.entityMappingAndPersistenceLab.repositories.EmployeeRepository;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Transactional
@Rollback(false)
@SpringBootTest
public class EmployeeServiceTest {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testAddNewEmployee() {
        Employee newEmployee = Employee
                .builder()
                .address("Kigali")
                .firstName("Paterne")
                .surname("Murenzi")
                .telephone("0798346489").build();

        int count = employeeRepository.findAll().size();

        Employee savedEmployee = employeeService.addEmployee(newEmployee);

        Assertions.assertNotNull(savedEmployee);

        Assertions.assertNotEquals(count, employeeRepository.findAll().size());
    }

    @Test
    public void testGetEmployeeById() {
        Employee employee = employeeService.getEmployeeById(employeeRepository.findAll().get(0).getEmployee_no());
        Assertions.assertNotNull(employee);
    }

    @Test
    public void testUpdateEmployee() {
        Employee employee = employeeService.getEmployeeById(employeeRepository.findAll().get(0).getEmployee_no());
        employee.setFirstName("Other");

        employeeService.updateEmployee(employee);

        employee = employeeService.getEmployeeById(employeeRepository.findAll().get(0).getEmployee_no());

        Assertions.assertNotNull(employee);

        Assertions.assertEquals("Other", employee.getFirstName());
    }

    @Test
    public void testDeleteEmployee() {
        int count = employeeRepository.findAll().size();
        boolean deleted = employeeService.deleteEmployee(employeeRepository.findAll().get(0).getEmployee_no());
        Assertions.assertEquals(true, deleted);
    }

    @Test
    public void testGetByFirstName() {
        Employee employee = employeeService.getEmployeeById(employeeRepository.findAll().get(0).getEmployee_no());
        Employee employee1 = employeeService.findByFirstName(employee.getFirstName());


        Assertions.assertNotNull(employee1);

        Assertions.assertEquals(employee, employee1);
    }
}