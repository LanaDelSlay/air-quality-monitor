package com.delslay.airqualitymonitor.controller;

import com.delslay.airqualitymonitor.model.SensorData;
import com.delslay.airqualitymonitor.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sensorData")
public class SensorDataController {
    @Autowired
    private SensorDataService sensorDataService;

    @PostMapping("/log")
    public ResponseEntity<SensorData> logSensorData(@RequestBody SensorData sensorData) {
        SensorData savedData = sensorDataService.saveSensorData(sensorData);
        return ResponseEntity.ok(savedData);
    }
}
