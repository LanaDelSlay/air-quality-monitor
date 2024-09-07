package com.delslay.airqualitymonitor.service;

import com.delslay.airqualitymonitor.model.Device;
import com.delslay.airqualitymonitor.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    public Device registerDevice(Device device) {
        return deviceRepository.save(device);
    }

    public Device findByDeviceId(String deviceId) {
        return deviceRepository.findByDeviceId(deviceId);
    }
}
