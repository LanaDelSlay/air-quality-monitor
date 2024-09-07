package com.delslay.airqualitymonitor.repository;

import com.delslay.airqualitymonitor.model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
    List<SensorData> findByDeviceId(Long deviceId);
}


