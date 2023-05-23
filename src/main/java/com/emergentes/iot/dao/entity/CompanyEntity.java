package com.emergentes.iot.dao.entity;

import com.emergentes.iot.model.Company;
import jakarta.persistence.*;

@Entity
@Table(name = "company")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long company_id;

    @Column(name = "company_name", length = 255)
    private String companyName;

    @Column(name = "company_api_key", length = 255)
    private String companyApiKey;

    @OneToOne(mappedBy = "company")
    private LocationEntity location;

    public Long getCompanyId() {
        return company_id;
    }

    public CompanyEntity() {
    }

    public CompanyEntity(Company company) {
        this.company_id = company.getCompanyId();
        this.companyName = company.getCompanyName();
        this.companyApiKey = company.getCompanyApiKey();
    }

    public void setCompany_id(Long company_id) {
        this.company_id = company_id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyApiKey() {
        return companyApiKey;
    }

    public void setCompanyApiKey(String companyApiKey) {
        this.companyApiKey = companyApiKey;
    }

    public LocationEntity getLocation() {
        return location;
    }

    public void setLocation(LocationEntity location) {
        this.location = location;
    }
}

