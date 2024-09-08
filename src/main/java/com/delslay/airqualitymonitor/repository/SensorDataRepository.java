package com.delslay.airqualitymonitor.repository;

import com.delslay.airqualitymonitor.model.SensorData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.time.LocalDateTime;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {
    List<SensorData> findByDeviceId(Long deviceId);
    List<SensorData> findByDevice_DeviceId(String deviceId);
    List<SensorData> findByDevice_DeviceIdAndTimestampAfter(String deviceId, LocalDateTime timestamp);
    List<SensorData> findByTimestampAfter(LocalDateTime timestamp);
}


