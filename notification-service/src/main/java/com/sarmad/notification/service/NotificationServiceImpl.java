package com.sarmad.notification.service;

import com.sarmad.notification.alert.NotificationAlert;
import com.sarmad.notification.dtos.AlertRequestDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService{
    private NotificationAlert notificationAlert;

    @Override
    @Transactional
    public String sendAlert(AlertRequestDto request) {
        //service code logic



        //after it publish notification, mock for now
        notificationAlert.sendNotification("");

        return "";
    }
}
