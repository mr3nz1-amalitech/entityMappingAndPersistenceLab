package com.mr3nz1.entityMappingAndPersistenceLab.repository;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Employee {
    @Id
    private int employee_no;

    @Column(nullable = false)
    private String sur_name;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String telephone;

}
