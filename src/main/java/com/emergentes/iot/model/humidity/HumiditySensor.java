package com.emergentes.iot.model.humidity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HumiditySensor {
    private Long sensorId;
    private String apiKey;
    private List<HumiditySensorData> humiditySensorData;
}
