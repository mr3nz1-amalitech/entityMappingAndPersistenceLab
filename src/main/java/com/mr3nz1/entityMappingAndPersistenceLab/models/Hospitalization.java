package com.mr3nz1.entityMappingAndPersistenceLab.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "hospitalization")
public class Hospitalization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int bed_no;

    @Column(nullable = false)
    private String diagnosis;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "patient_no", referencedColumnName = "patient_no")
    private Patient patient;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ward_no", referencedColumnName = "id")
    private Ward ward_no;

}
