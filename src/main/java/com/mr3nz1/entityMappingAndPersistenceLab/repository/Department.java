package com.mr3nz1.entityMappingAndPersistenceLab.repository;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "departments")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long department_code;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String building;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_no", referencedColumnName = "doctor_no")
    private Doctor head_of_department;
}
