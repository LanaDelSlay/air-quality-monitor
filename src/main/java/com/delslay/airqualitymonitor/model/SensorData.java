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
    private Double toluenePpm;
    private Double formaldehydePpm;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "device_id")
    private Device device;

    public SensorData() {}

    @PrePersist
    protected void onCreate() {
        this.timestamp = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getVocCount() {
        return vocCount;
    }

    public void setVocCount(Double vocCount) {
        this.vocCount = vocCount;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getToluenePpm() {
        return toluenePpm;
    }

    public void setToluenePpm(Double toluenePpm) {
        this.toluenePpm = toluenePpm;
    }

    public void setFormaldehydePpm(Double formaldehydePpm) {
        this.formaldehydePpm = formaldehydePpm;
    }

    public Double getFormaldehydePpm() {
        return formaldehydePpm;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Device getDevice() {
        return device;
    }

    public void setDevice(Device device) {
        this.device = device;
    }
}
