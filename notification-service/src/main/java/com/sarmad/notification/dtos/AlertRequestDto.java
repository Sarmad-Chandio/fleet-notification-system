package com.sarmad.notification.dtos;

import com.sarmad.notification.enums.AlertType;
import com.sarmad.notification.enums.SeverityType;
import com.sarmad.notification.enums.StatusType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlertRequestDto {
    @NotNull(message = "Title is required")
    private String title;
    private String message;
    @NotNull(message = "type is required")
    private AlertType type;
    @NotNull(message = "severity is required")
    private SeverityType severity;
    @NotNull(message = "status is required")
    private StatusType status;
    private Integer driverId;
    private Integer vehicleId;

}
