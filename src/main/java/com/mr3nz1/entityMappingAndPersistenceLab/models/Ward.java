package com.mr3nz1.entityMappingAndPersistenceLab.models;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("wards")
public class Ward {
    @Id
    private Long id;

    private Long bed_count;

    private String ward_no;

    @DBRef
    @OneToOne
    private Nurse supervisor;

    @DBRef
    @OneToOne
    private Department department_code;
}
