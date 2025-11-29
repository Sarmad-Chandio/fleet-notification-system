package com.sarmad.notification.repository;

import com.sarmad.notification.entities.DriverAlertEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverAlertRepository extends JpaRepository<DriverAlertEntity, Integer> {
}
