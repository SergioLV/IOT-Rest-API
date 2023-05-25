package com.emergentes.iot.dto.responses;

import com.emergentes.iot.model.Sensor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SensorResponse {
    String message;
    Sensor sensor;
}
