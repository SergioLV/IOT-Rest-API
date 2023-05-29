package com.emergentes.iot.dto.requests;

import com.emergentes.iot.model.humidity.HumiditySensorData;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class HumiditySensorRequest {
    private String apiKey;
    private List<HumiditySensorData> jsonData;
}
