package com.mr3nz1.entityMappingAndPersistenceLab.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("nurses")
public class Nurse {
    @Id
    @OneToOne
    private Employee nurse_no;

    private String rotation;

    private String salary;

    @DBRef
    @OneToOne
    private Department department_code;
}