package com.sarmad.trackingservice.dto;

import com.sarmad.trackingservice.enums.AlertType;
import com.sarmad.trackingservice.enums.SeverityType;
import com.sarmad.trackingservice.enums.StatusType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
