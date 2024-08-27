package com.mr3nz1.entityMappingAndPersistenceLab.services;

import com.mr3nz1.entityMappingAndPersistenceLab.models.Employee;
import com.mr3nz1.entityMappingAndPersistenceLab.repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            System.out.println("#####################^^^^^^^^^^^^^^^^^^##################");
            System.out.println(employee);
            System.out.println("#####################^^^^^^^^^^^^^^^^^^##################");
            return employeeRepository.findById(id).get();
        }

        return null;
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public boolean deleteEmployee(int id) {
        try {
            employeeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Employee findByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }
}
