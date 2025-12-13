package com.sarmad.trackingservice.service;

import com.sarmad.trackingservice.client.NotificationClient;
import com.sarmad.trackingservice.dto.GpsLocationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GpsServiceImpl implements GpsService{
    private final NotificationClient notificationClient;
    @Override
    public void processLocation(GpsLocationDto gpsLocationDto) {

        if (gpsLocationDto.getSpeed() > 90) {
            notificationClient.sendSpeedAlert(gpsLocationDto);
        }


    }
}
