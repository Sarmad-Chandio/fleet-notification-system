package com.sarmad.notification.controller;

import com.sarmad.notification.dtos.AlertRequestDto;
import com.sarmad.notification.service.NotificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1")
public class NotificationController {

    private NotificationService notificationService;

    @PostMapping("/alert")
    public ResponseEntity<String> createAlert(@RequestBody @Validated AlertRequestDto request) {
        return ResponseEntity.ok(notificationService.sendAlert(request));
    }






}
