package com.emergentes.iot.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Sensor {
    private long locationId;
    private String sensorName;
    private String sensorCategory;
    private String sensorMeta;
    private String sensorApiKey;
}
