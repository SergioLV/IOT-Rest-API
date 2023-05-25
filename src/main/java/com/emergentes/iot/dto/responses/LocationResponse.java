package com.emergentes.iot.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class LocationResponse {
    private String message;
    private Long locationId;
}
