package com.delslay.airqualitymonitor.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double vocCount;
    private Double temperature;
    private Double humidity;
    private Double gasLevel;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    public SensorData() {
    }

    public SensorData(Double vocCount, Double temperature, Double humidity, Double gasLevel, LocalDateTime timestamp, Device device) {
        this.vocCount = vocCount;
        this.temperature = temperature;
        this.humidity = humidity;
        this.gasLevel = gasLevel;
        this.timestamp = timestamp;
        this.device = device;
    }
    
}
