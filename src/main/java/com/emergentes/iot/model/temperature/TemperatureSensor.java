package com.emergentes.iot.model.temperature;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemperatureSensor {
    private Long sensorId;
    private String apiKey;
    private List<TemperatureSensorData> temperatureSensorData;
}
