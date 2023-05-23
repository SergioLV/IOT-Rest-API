package com.emergentes.iot.dto.requests;

import jakarta.validation.constraints.NotNull;

public class CompanyRequest {

    @NotNull(message = "company_name is mandatory")
    private String company_name;

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getCompanyName() {
        return company_name;
    }

    public void setCompanyName(String company_name) {
        this.company_name = company_name;
    }
}
