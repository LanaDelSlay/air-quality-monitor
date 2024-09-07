package com.delslay.airqualitymonitor.controller;

import com.delslay.airqualitymonitor.model.Device;
import com.delslay.airqualitymonitor.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/devices")
public class DeviceController {
    @Autowired
    private DeviceService deviceService;

    @PostMapping("/register")
    public ResponseEntity<Device> registerDevice(@RequestBody Device device) {
        Device newDevice = deviceService.registerDevice(device);
        return ResponseEntity.ok(newDevice);
    }

    @GetMapping("/{deviceId}")
    public ResponseEntity<Device> getDevice(@PathVariable String deviceId) {
        Device device = deviceService.findByDeviceId(deviceId);
        return ResponseEntity.ok(device);
    }
}
