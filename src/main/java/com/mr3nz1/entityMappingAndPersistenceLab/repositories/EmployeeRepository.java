package com.mr3nz1.entityMappingAndPersistenceLab.repositories;

import com.mr3nz1.entityMappingAndPersistenceLab.models.Employee;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, ObjectId> {
    Employee findByFirstName(String firstName);
}
