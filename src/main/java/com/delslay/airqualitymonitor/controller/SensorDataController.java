package com.delslay.airqualitymonitor.controller;

import com.delslay.airqualitymonitor.model.SensorData;
import com.delslay.airqualitymonitor.model.Device;
import com.delslay.airqualitymonitor.service.DeviceService;
import com.delslay.airqualitymonitor.service.SensorDataService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    
    if (device == null) {
        device = new Device(sensorData.getDevice().getDeviceId(), "New Device", "Default Location");
        device = deviceService.registerDevice(device);
    }
    sensorData.setDevice(device);
    SensorData savedData = sensorDataService.saveSensorData(sensorData);
    return ResponseEntity.ok(savedData);
}

    @GetMapping("/logs")
    public ResponseEntity<List<SensorData>> getAllSensorLogs() {
        List<SensorData> allSensorLogs = sensorDataService.getAllSensorData();
        return ResponseEntity.ok(allSensorLogs);
    }

    @GetMapping("/logs/{deviceId}")
    public ResponseEntity<List<SensorData>> getSensorLogsByDeviceId(@PathVariable String deviceId) {
        List<SensorData> sensorLogs = sensorDataService.getLogsByDeviceId(deviceId);
        return ResponseEntity.ok(sensorLogs);
    }
    
    @GetMapping("/logs/{deviceId}/last30days")
    public ResponseEntity<List<SensorData>> getSensorLogsByDeviceIdLast30Days(@PathVariable String deviceId) {
        List<SensorData> sensorLogs = sensorDataService.getLogsByDeviceIdLast30Days(deviceId);
        return ResponseEntity.ok(sensorLogs);
    }

    @GetMapping("/logs/last30days")
    public ResponseEntity<List<SensorData>> getAllSensorLogsLast30Days() {
        List<SensorData> allSensorLogs = sensorDataService.getAllSensorDataLast30Days();
        return ResponseEntity.ok(allSensorLogs);
    }
}
