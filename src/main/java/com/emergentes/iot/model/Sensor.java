package com.emergentes.iot.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sensor {
    private Long sensorId;
    private Location location;
    private String sensorName;
    private String sensorCategory;
    private String sensorMeta;
    private String sensorApiKey;


}
