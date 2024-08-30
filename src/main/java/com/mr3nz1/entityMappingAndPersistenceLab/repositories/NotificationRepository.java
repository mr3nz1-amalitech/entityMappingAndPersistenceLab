package com.mr3nz1.entityMappingAndPersistenceLab.repositories;

import com.mr3nz1.entityMappingAndPersistenceLab.models.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends CrudRepository<Notification, String> {

}
