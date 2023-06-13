package com.emergentes.iot.dto.requests;

import com.emergentes.iot.model.temperature.TemperatureSensorData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemperatureSensorRequest {
    private String apiKey;
    private List<TemperatureSensorData> jsonData;
}
