package com.mr3nz1.entityMappingAndPersistenceLab.services;

import com.mr3nz1.entityMappingAndPersistenceLab.models.Notification;
import com.mr3nz1.entityMappingAndPersistenceLab.repositories.NotificationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NotificationService {
    private final NotificationRepository notificationRepository;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public void save(Notification notification) {
        notificationRepository.save(notification);
    }

    public Notification get(String id) throws Exception {
        Optional<Notification> notification = notificationRepository.findById(id);

        if (notification.isEmpty()) throw new Exception("Notification with id: " + id + " not found");

        return notification.get();
    }

    public void delete(Notification notification) {
        notificationRepository.delete(notification);
    }

    public List<Notification> findAll() {
        return (List<Notification>) notificationRepository.findAll( );
    }
}
