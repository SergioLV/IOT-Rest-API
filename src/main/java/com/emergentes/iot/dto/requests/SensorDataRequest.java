package com.emergentes.iot.dto.requests;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class SensorDataRequest {
    private Long companyId;
    private String companyApiKey;
    private Long from;
    private Long to;
    private List<Integer> sensorsId;
}
