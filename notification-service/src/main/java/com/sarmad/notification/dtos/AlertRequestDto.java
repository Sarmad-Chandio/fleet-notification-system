package com.sarmad.notification.dtos;

import com.sarmad.notification.enums.AlertType;
import com.sarmad.notification.enums.SeverityType;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AlertRequestDto {
    private String title;
    private String message;
    private AlertType type;
    private SeverityType severity;
    private String status;

}
