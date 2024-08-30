package com.mr3nz1.entityMappingAndPersistenceLab.models;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@Data
@Builder
@RedisHash("Notification")
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Notification implements Serializable {
    @Id
    @ToString.Include
    private String id;

    @Indexed
    @NonNull
    private String title;

    @Indexed
    @NonNull
    private String body;
}
