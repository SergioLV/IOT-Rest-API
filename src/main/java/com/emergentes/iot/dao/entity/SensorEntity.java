package com.emergentes.iot.dao.entity;

import com.emergentes.iot.model.Sensor;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "sensor")
public class SensorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sensor_id")
    private Long sensorId;

    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "sensor_name", length = 255)
    private String sensorName;

    @Column(name = "sensor_category", length = 255)
    private String sensorCategory;

    @Column(name = "sensor_meta", length = 255)
    private String sensorMeta;

    @Column(name = "sensor_api_key", length = 255)
    private String sensorApiKey;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id", insertable = false, updatable = false)
    private LocationEntity location;

    public SensorEntity(){}

    public SensorEntity(Sensor sensor){
        this.locationId = sensor.getLocationId();
        this.sensorName = sensor.getSensorName();
        this.sensorCategory = sensor.getSensorCategory();
        this.sensorMeta = sensor.getSensorMeta();
        this.sensorApiKey = getSensorApiKey();
    }
}

