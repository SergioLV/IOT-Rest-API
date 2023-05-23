package com.emergentes.iot.model;

public class Company {
    private String company_name;
    private Long company_id;


    private String companyApiKey;

    public Long getCompanyId() {
        return company_id;
    }


    public void setCompanyId(Long id) {
        this.company_id = company_id;
    }

    public String getCompanyName() {
        return company_name;
    }

    public void setCompanyName(String company_name) {
        this.company_name = company_name;
    }

    public String getCompanyApiKey() {
        return companyApiKey;
    }

    public void setCompanyApiKey(String companyApiKey) {
        this.companyApiKey = companyApiKey;
    }


}
