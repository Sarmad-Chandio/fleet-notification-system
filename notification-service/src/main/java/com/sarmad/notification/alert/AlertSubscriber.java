package com.sarmad.notification.alert;

import com.sarmad.notification.dtos.AlertRequestDto;
import jakarta.annotation.PostConstruct;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.*;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import java.lang.reflect.Type;

@Component
public class AlertSubscriber implements StompSessionHandler {

    private static final String WS_URL = "ws://localhost:8080/ws";

    @PostConstruct
    public void init() {
        WebSocketStompClient stompClient =
                new WebSocketStompClient(new StandardWebSocketClient());
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        System.out.println("Connecting Subscriber to WebSocket...");
        stompClient.connectAsync(WS_URL, this);
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        System.out.println("Subscriber WebSocket Connected ✔");

        session.subscribe("/topic/alerts", this);
        session.subscribe("/topic/alerts/vehicle", this);
        session.subscribe("/topic/alerts/driver", this);

        System.out.println("Subscribed to Alert Topics ✔");
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return AlertRequestDto.class; // deserialize into DTO automatically
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        System.out.println("REAL-TIME ALERT: " + payload);
    }

    @Override
    public void handleException(StompSession session, StompCommand command,
                                StompHeaders headers, byte[] payload, Throwable exception) {
        System.err.println("Frame Handling Exception: " + exception.getMessage());
    }

    @Override
    public void handleTransportError(StompSession session, Throwable exception) {
        System.err.println("Transport Error: " + exception.getMessage());
    }
}


