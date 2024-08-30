package com.mr3nz1.entityMappingAndPersistenceLab.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("hospitalization")
public class Hospitalization {
    @Id
    private long id;

    private int bed_no;

    private String diagnosis;

    @DBRef
    @ManyToOne
    private Patient patient;

    @DBRef
    @ManyToOne
    private Ward ward_no;

}
