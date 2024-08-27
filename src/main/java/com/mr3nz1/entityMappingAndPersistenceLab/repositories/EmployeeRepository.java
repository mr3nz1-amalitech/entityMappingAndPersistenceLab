package com.mr3nz1.entityMappingAndPersistenceLab.repositories;

import com.mr3nz1.entityMappingAndPersistenceLab.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByFirstName(String firstName);
}
