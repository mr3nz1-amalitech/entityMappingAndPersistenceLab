package com.mr3nz1.entityMappingAndPersistenceLab.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "wards")
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long bed_count;

    @Column(nullable = false)
    private String ward_no;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn
    private Nurse supervisor;

    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Department department_code;
}
