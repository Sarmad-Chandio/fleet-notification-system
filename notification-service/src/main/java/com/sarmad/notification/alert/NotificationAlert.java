package com.sarmad.notification.alert;

import com.sarmad.notification.dtos.AlertRequestDto;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class NotificationAlert {

    /*
    /topic/alerts

    /topic/driver-status

    /topic/vehicle-alerts/{id}

    Add DB tables:
    alerts
    notification_status
    alert_history
*/

    //correct and change it later
    @MessageMapping("/alerts")
    public void handleWebSocketAlert(AlertRequestDto alertReqMessage) {
        System.out.println("Received WebSocket alert: " + alertReqMessage);
    }

}
