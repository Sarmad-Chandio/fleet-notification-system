package com.sarmad.notification.repository;

import com.sarmad.notification.entities.VehicleAlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleAlertRepository extends JpaRepository<VehicleAlertEntity,Integer> {
}
