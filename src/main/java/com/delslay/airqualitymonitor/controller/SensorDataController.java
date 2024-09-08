package com.delslay.airqualitymonitor.controller;

import com.delslay.airqualitymonitor.model.SensorData;
import com.delslay.airqualitymonitor.model.Device;
import com.delslay.airqualitymonitor.service.DeviceService;
import com.delslay.airqualitymonitor.service.SensorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sensorData")
public class SensorDataController {

    @Autowired
    private SensorDataService sensorDataService;

    @Autowired
    private DeviceService deviceService;

    @PostMapping("/log")
    public ResponseEntity<SensorData> logSensorData(@RequestBody SensorData sensorData) {
        Device device = deviceService.findByDeviceId(sensorData.getDevice().getDeviceId());
        sensorData.setDevice(device); 
        SensorData savedData = sensorDataService.saveSensorData(sensorData);
        return ResponseEntity.ok(savedData);
    }
}
