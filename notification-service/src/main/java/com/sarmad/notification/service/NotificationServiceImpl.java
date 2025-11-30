package com.sarmad.notification.service;

import com.sarmad.notification.alert.NotificationAlert;
import com.sarmad.notification.dtos.AlertRequestDto;
import com.sarmad.notification.entities.AlertEntity;
import com.sarmad.notification.entities.DriverAlertEntity;
import com.sarmad.notification.entities.VehicleAlertEntity;
import com.sarmad.notification.enums.AlertType;
import com.sarmad.notification.mappers.AlertMapper;
import com.sarmad.notification.repository.AlertRepository;
import com.sarmad.notification.repository.DriverAlertRepository;
import com.sarmad.notification.repository.VehicleAlertRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class NotificationServiceImpl implements NotificationService{
    private NotificationAlert notificationAlert;
    private AlertMapper alertMapper;
    private AlertRepository alertRepository;
    private DriverAlertRepository driverAlertRepository;
    private VehicleAlertRepository vehicleAlertRepository;
    private SimpMessagingTemplate messagingTemplate;



    @Override
    @Transactional
    public String sendAlert(AlertRequestDto request) {
        //calling mappers to map to entities
        AlertEntity alertEntity = alertMapper.toAlertEntity(request);
        //saving into entity table
        alertEntity = alertRepository.save(alertEntity);

        if (AlertType.VEHICLE.equals(request.getType())){
            VehicleAlertEntity vehicleAlertEntity = alertMapper.toVehicleAlertEntity(request);
            //Attaching the saved alert entity using MapStruct
            alertMapper.updateVehicleAlertWithAlert(vehicleAlertEntity,alertEntity);

            vehicleAlertRepository.save(vehicleAlertEntity);
            // Websocket Publish
            messagingTemplate.convertAndSend("/topic/alerts/vehicle", request);
        } else if (AlertType.DRIVER.equals(request.getType())) {
            DriverAlertEntity driverAlertEntity = alertMapper.toDriverAlertEntity(request);

            alertMapper.updateDriverAlertWithAlert(driverAlertEntity,alertEntity);

            driverAlertRepository.save(driverAlertEntity);
            //Websocket Publish
            messagingTemplate.convertAndSend("/topic/alerts/driver", request);
        }



        //All alerts stream (for monitoring dashboards)
        messagingTemplate.convertAndSend("/topic/alerts", request);

        return "Notification sent SuccessFully ";
    }
}
