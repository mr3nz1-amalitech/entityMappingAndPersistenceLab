package com.mr3nz1.entityMappingAndPersistenceLab.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employee_no;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String telephone;

}
