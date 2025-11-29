package com.sarmad.notification.dtos;

import com.sarmad.notification.enums.AlertType;
import com.sarmad.notification.enums.SeverityType;
import com.sarmad.notification.enums.StatusType;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlertRequestDto {
    @NotBlank(message = "Title is required")
    private String title;
    private String message;
    @NotBlank(message = "type is required")
    private AlertType type;
    @NotBlank(message = "severity is required")
    private SeverityType severity;
    @NotBlank(message = "status is required")
    private StatusType status;

}
