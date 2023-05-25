package com.emergentes.iot.dto.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocationRequest {
    @NotNull(message = "Company id is mandatory")
    private long companyId;
    @NotNull(message = "Location name is mandatory")
    private String locationName;
    @NotNull(message = "Location country is mandatory")
    private String locationCountry;
    @NotNull(message = "Location city is mandatory")
    private String locationCity;
    @NotNull(message = "Location meta is mandatory")
    private String locationMeta;
}
