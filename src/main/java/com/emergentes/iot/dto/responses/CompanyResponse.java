package com.emergentes.iot.dto.responses;

import com.emergentes.iot.model.Company;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CompanyResponse {
    private String message;
    private Company company;

}
