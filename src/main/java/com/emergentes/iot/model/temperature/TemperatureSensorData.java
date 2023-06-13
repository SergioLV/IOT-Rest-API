package com.emergentes.iot.model.temperature;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class TemperatureSensorData {
    private LocalDateTime date;
    private BigDecimal temperature;
}
