package com.mr3nz1.entityMappingAndPersistenceLab.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "patients")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long patient_no;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private String telephone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_no", referencedColumnName = "doctor_no")
    private Doctor doctor_no;
}
