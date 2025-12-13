package com.sarmad.trackingservice.dto;

import lombok.Data;

import java.time.Instant;

@Data
public class GpsLocationDto {
    private Long vehicleId;
    private double latitude;
    private double longitude;
    private double speed;
    private Instant timestamp;
}
