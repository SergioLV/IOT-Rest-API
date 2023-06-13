package com.emergentes.iot.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "temperature_sensors_data")
public class TemperatureSensorsDataEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "temperature_sensor_id")
    private Long temperatureSensorId;

    @Column(name = "sensor_id")
    private Long sensorId;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "temperature")
    private BigDecimal temperature;

    public TemperatureSensorsDataEntity() {

    }
}
