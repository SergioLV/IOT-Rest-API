package com.emergentes.iot.model.humidity;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class HumiditySensorData {
    private LocalDateTime date;
    private BigDecimal percentage;
}
