package com.delslay.airqualitymonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.delslay.airqualitymonitor")
public class AirQualityMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirQualityMonitorApplication.class, args);
    }
}
