package com.sarmad.notification.mappers;

import com.sarmad.notification.dtos.AlertRequestDto;
import com.sarmad.notification.entities.AlertEntity;
import com.sarmad.notification.entities.DriverAlertEntity;
import com.sarmad.notification.entities.VehicleAlertEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AlertMapper {

    // 1. From DTO → AlertEntity
    AlertEntity toAlertEntity(AlertRequestDto dto);

    // 2. From DTO → DriverAlertEntity (without alert set yet)
    @Mapping(target = "alert", ignore = true)
    @Mapping(target = "acknowledgedAt", ignore = true)
    @Mapping(target = "readStatus", constant = "false")
    DriverAlertEntity toDriverAlertEntity(AlertRequestDto dto);

    // 3. From DTO → VehicleAlertEntity (without alert set yet)
    @Mapping(target = "alert", ignore = true)
    @Mapping(target = "acknowledgedAt", ignore = true)
    @Mapping(target = "readStatus", constant = "false")
    VehicleAlertEntity toVehicleAlertEntity(AlertRequestDto dto);

    // 4. Add the saved AlertEntity to child entities
    @Mapping(target = "alert", source = "alert")
    void updateDriverAlertWithAlert(@MappingTarget DriverAlertEntity entity, AlertEntity alert);

    @Mapping(target = "alert", source = "alert")
    void updateVehicleAlertWithAlert(@MappingTarget VehicleAlertEntity entity, AlertEntity alert);
}

