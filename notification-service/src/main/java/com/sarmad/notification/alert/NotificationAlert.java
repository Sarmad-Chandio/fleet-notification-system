package com.sarmad.notification.alert;

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
    @MessageMapping("/sendAlert")//-> default pick url from config : notification-app/sendNotification
    @SendTo("/topic/notificaton")//configutre topic same as config
    public String sendNotification(String message){
        System.out.println("message :"+message);
        return message;
    }

}
