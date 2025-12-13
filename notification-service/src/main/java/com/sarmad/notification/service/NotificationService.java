package com.sarmad.notification.service;

import com.sarmad.notification.dtos.AlertRequestDto;

public interface NotificationService {
    String sendAlert(AlertRequestDto request);
}
