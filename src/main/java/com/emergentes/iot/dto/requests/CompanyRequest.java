package com.emergentes.iot.dto.requests;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyRequest {
    @NotNull(message = "company_name is mandatory")
    private String companyName;
}
