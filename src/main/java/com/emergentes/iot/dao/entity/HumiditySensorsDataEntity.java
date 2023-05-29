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
@Table(name = "humidity_sensors_data")
public class HumiditySensorsDataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "humidity_sensor_id")
    private Long humidity_sensor_id;

    @Column(name = "sensor_id")
    private Long sensor_id;

    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    @Column(name = "percentage")
    private BigDecimal percentage;

    public HumiditySensorsDataEntity() {

    }
}
