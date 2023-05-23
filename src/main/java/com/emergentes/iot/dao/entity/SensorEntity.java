package com.emergentes.iot.dao.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "sensor")
public class SensorEntity {
    @Id
    @Column(name = "sensor_id")
    private Long sensorId;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private LocationEntity location;

    @Column(name = "sensor_name", length = 255)
    private String sensorName;

    @Column(name = "sensor_category", length = 255)
    private String sensorCategory;

    @Column(name = "sensor_meta", length = 255)
    private String sensorMeta;

    @Column(name = "sensor_api_key", length = 255)
    private String sensorApiKey;

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getSensorCategory() {
        return sensorCategory;
    }

    public void setSensorCategory(String sensorCategory) {
        this.sensorCategory = sensorCategory;
    }

    public String getSensorMeta() {
        return sensorMeta;
    }

    public void setSensorMeta(String sensorMeta) {
        this.sensorMeta = sensorMeta;
    }

    public String getSensorApiKey() {
        return sensorApiKey;
    }

    public void setSensorApiKey(String sensorApiKey) {
        this.sensorApiKey = sensorApiKey;
    }
}

