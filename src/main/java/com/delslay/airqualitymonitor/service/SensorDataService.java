package com.delslay.airqualitymonitor.service;

import com.delslay.airqualitymonitor.model.SensorData;
import com.delslay.airqualitymonitor.repository.SensorDataRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.time.LocalDateTime;

@Service
public class SensorDataService {
    @Autowired
    private SensorDataRepository sensorDataRepository;

    public SensorData saveSensorData(SensorData sensorData) {
        return sensorDataRepository.save(sensorData);
    }

    public List<SensorData> getLogsByDeviceId(String deviceId) {
        return sensorDataRepository.findByDevice_DeviceId(deviceId);
    }

    public List<SensorData> getAllSensorData() {
        return sensorDataRepository.findAll();
    }

    public List<SensorData> getLogsByDeviceIdLast30Days(String deviceId) {
        LocalDateTime thirtyDaysAgo = LocalDateTime.now().minusDays(30);
        return sensorDataRepository.findByDevice_DeviceIdAndTimestampAfter(deviceId, thirtyDaysAgo);
    }

    public List<SensorData> getAllSensorDataLast30Days() {
        LocalDateTime thirtyDaysAgo = LocalDateTime.now().minusDays(30);
        return sensorDataRepository.findByTimestampAfter(thirtyDaysAgo);
    }
}
