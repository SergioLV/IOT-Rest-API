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
    private LocalDateTime from;
    private LocalDateTime to;
    private List<Integer> sensorsId;
}
