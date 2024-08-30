package com.mr3nz1.entityMappingAndPersistenceLab.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long department_code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String building;

    @DBRef
    @OneToOne(cascade = CascadeType.ALL)
    private Doctor head_of_department;
}
