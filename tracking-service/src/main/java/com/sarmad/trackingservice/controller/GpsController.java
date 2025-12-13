package com.sarmad.trackingservice.controller;

import com.sarmad.trackingservice.dto.GpsLocationDto;
import com.sarmad.trackingservice.service.GpsService;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Tracking Service APIs")
public class GpsController {

    private GpsService gpsService;

    @PostMapping("/updateLocation")
    public ResponseEntity<Void> createAlert(@RequestBody @Validated GpsLocationDto gpsLocationDto) {
        gpsService.processLocation(gpsLocationDto);
        return ResponseEntity.accepted().build();
    }

}
