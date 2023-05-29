package com.emergentes.iot.model;

import com.emergentes.iot.dao.entity.SensorEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Sensor {
    private long locationId;
    private String sensorName;
    private String sensorCategory;
    private String sensorMeta;
    private String sensorApiKey;

    public Sensor(){}
    public Sensor(SensorEntity sensorEntity){
        this.locationId = sensorEntity.getLocationId();
        this.sensorName = sensorEntity.getSensorName();
        this.sensorCategory = sensorEntity.getSensorCategory();
        this.sensorMeta = sensorEntity.getSensorMeta();
        this.sensorApiKey = sensorEntity.getSensorApiKey();
    }
}
