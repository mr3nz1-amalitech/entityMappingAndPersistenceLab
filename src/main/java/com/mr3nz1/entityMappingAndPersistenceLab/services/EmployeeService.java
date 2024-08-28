package com.mr3nz1.entityMappingAndPersistenceLab.services;

import com.mr3nz1.entityMappingAndPersistenceLab.models.Employee;
import com.mr3nz1.entityMappingAndPersistenceLab.repositories.EmployeeRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private EmployeeRepository employeeRepository;
    private TransactionManager transactionManager;

    public EmployeeService(EmployeeRepository employeeRepository, TransactionManager transactionManager) {
        this.employeeRepository = employeeRepository;
        this.transactionManager = transactionManager;
    }

    @Cacheable("employees")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Cacheable(value = "employee", key = "#id")
    public Employee getEmployeeById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()) {
            return employeeRepository.findById(id).get();
        }

        return null;
    }


    @CachePut(value = "employee", key = "#employee.employee_no")
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @CachePut(value = "employee", key = "#employee.employee_no")
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @CacheEvict(value = "employee", key = "#id")
    public boolean deleteEmployee(int id) {
        try {
            employeeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Cacheable(value = "employee", key = "#firstName")
    public Employee findByFirstName(String firstName) {
        return employeeRepository.findByFirstName(firstName);
    }

    @Transactional
    public boolean deleteEmployees(int[] ids) {
        try {
            DefaultTransactionDefinition def = new DefaultTransactionDefinition();
            Arrays.stream(ids).forEach(this::deleteEmployee);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
