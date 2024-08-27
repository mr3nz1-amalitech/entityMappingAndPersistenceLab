package com.mr3nz1.entityMappingAndPersistenceLab.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class Doctor {
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_no", referencedColumnName = "employee_no")
    private Employee doctor_no;

    @Column(nullable = false)
    private String specialization;
}
