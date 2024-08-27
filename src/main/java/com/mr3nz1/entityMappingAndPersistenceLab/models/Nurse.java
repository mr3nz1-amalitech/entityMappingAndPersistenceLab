package com.mr3nz1.entityMappingAndPersistenceLab.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "nurses")
public class Nurse {
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Employee nurse_no;

    @Column(nullable = false)
    private String rotation;

    @Column(nullable = false)
    private String salary;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "department_code", referencedColumnName = "department_code")
    private Department department_code;
}