package com.emergentes.iot.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SensorRequest {
    private long locationId;
    private String sensorName;
    private String sensorCategory;
    private String sensorMeta;
    private String sensorApiKey;
}
