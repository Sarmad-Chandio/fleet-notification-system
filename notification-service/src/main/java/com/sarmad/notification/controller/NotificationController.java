package com.sarmad.notification.controller;

import com.sarmad.notification.dtos.AlertRequestDto;
import com.sarmad.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/alerts")
public class NotificationController {

    private NotificationService notificationService;

    public ResponseEntity<String> createAlert(@RequestBody AlertRequestDto request) {
        return ResponseEntity.ok(notificationService.sendAlert(request));
    }






}
