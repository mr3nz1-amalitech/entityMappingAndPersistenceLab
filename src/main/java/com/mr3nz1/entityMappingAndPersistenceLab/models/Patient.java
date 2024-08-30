package com.mr3nz1.entityMappingAndPersistenceLab.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("patients")
public class Patient {
    @Id
    private Long patient_no;

    private String surname;

    private String first_name;

    private String address;

    private String telephone;

    @DBRef
    @OneToOne(cascade = CascadeType.ALL)
    private Doctor doctor_no;
}
