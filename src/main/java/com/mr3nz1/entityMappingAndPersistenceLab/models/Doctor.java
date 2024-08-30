package com.mr3nz1.entityMappingAndPersistenceLab.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("users")
public class Doctor {
    @Id
    @DBRef
    @OneToOne
    private Employee doctor_no;

    @Column(nullable = false)
    private String specialization;
}
