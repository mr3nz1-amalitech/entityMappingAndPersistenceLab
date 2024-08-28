package com.mr3nz1.entityMappingAndPersistenceLab;

import com.mr3nz1.entityMappingAndPersistenceLab.services.EmployeeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class EntityMappingAndPersistenceLabApplication {
    public static void main(String[] args) {
        SpringApplication.run(EntityMappingAndPersistenceLabApplication.class, args);
    }
}
