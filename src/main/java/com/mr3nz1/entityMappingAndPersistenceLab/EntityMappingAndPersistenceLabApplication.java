package com.mr3nz1.entityMappingAndPersistenceLab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@EnableCaching
@SpringBootApplication
@EnableRedisRepositories
public class EntityMappingAndPersistenceLabApplication {
    public static void main(String[] args) {
        SpringApplication.run(EntityMappingAndPersistenceLabApplication.class, args);
    }
}
