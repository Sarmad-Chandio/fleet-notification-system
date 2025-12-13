package com.sarmad.trackingservice.service;

import com.sarmad.trackingservice.dto.GpsLocationDto;

public interface GpsService {
    void processLocation (GpsLocationDto gpsLocationDto);
}
