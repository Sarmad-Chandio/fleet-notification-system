package com.sarmad.trackingservice.client;

import com.sarmad.trackingservice.dto.AlertRequestDto;
import com.sarmad.trackingservice.dto.GpsLocationDto;
import com.sarmad.trackingservice.enums.AlertType;
import com.sarmad.trackingservice.enums.SeverityType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class NotificationClient {

    private final RestTemplate restTemplate;

    public void sendSpeedAlert(GpsLocationDto dto) {

        AlertRequestDto alert = new AlertRequestDto();
        alert.setTitle("Overspeed");
        alert.setMessage("Speed exceeded 90 km/h");
        alert.setType(AlertType.VEHICLE);
        alert.setSeverity(SeverityType.HIGH);
        alert.setVehicleId(dto.getVehicleId());

        restTemplate.postForEntity(
                "http://localhost:8081/api/v1/alerts",
                alert,
                Void.class
        );
    }
}

