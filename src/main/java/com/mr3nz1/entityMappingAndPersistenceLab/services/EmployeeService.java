package com.mr3nz1.entityMappingAndPersistenceLab.services;

import com.mongodb.client.MongoClients;
import com.mr3nz1.entityMappingAndPersistenceLab.models.Employee;
import com.mr3nz1.entityMappingAndPersistenceLab.repositories.EmployeeRepository;
import org.bson.types.ObjectId;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    RedisTemplate<String, Object> redisTemplate;

    public EmployeeService(EmployeeRepository employeeRepository, RedisTemplate<String, Object> redisTemplate) {
        this.employeeRepository = employeeRepository;
        this.redisTemplate = redisTemplate;
    }

    public Employee addEmployee(Employee employee) {
        Employee newEmployee = employeeRepository.save(employee);
        redisTemplate.opsForSet().add(employee.getId() + "", employee);
        return newEmployee;
    }

    @Cacheable(value = "employees")
    public List<Employee> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Cacheable(value = "employees", key = "#id")
    public Employee getEmployeeById(ObjectId id) throws Exception {
        if (!employeeRepository.existsById(id)) throw new Exception("Can't find employee of id : " + id);

        return employeeRepository.findById(id).get();
    }
}
