package com.mr3nz1.entityMappingAndPersistenceLab.controllers;

import com.mr3nz1.entityMappingAndPersistenceLab.models.Notification;
import com.mr3nz1.entityMappingAndPersistenceLab.services.NotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/add")
    public String addNotification() {
        notificationService.save(
                Notification
                        .builder()
                        .id("#id1")
                        .title("Learning redis")
                        .body("Description for learning redist")
                        .build()
        );

        return "Saved";
    }

    @GetMapping("/all")
    public List<Notification> getNotification() {
        return notificationService.findAll();
    }

    @GetMapping("/delete")
    public String deleteNotification() throws Exception {
        Notification notification = notificationService.get("#id1");
        notificationService.delete(notification);
        return "Deleted";
    }
}
