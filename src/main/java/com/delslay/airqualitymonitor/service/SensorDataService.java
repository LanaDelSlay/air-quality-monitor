package com.delslay.airqualitymonitor.service;

import com.delslay.airqualitymonitor.model.SensorData;
import com.delslay.airqualitymonitor.repository.SensorDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SensorDataService {
    @Autowired
    private SensorDataRepository sensorDataRepository;

    public SensorData saveSensorData(SensorData sensorData) {
        return sensorDataRepository.save(sensorData);
    }
}
