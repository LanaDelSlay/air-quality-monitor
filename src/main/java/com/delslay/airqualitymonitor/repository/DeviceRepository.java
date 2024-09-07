package com.delslay.airqualitymonitor.repository;

import com.delslay.airqualitymonitor.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
    Device findByDeviceId(String deviceId);
}
