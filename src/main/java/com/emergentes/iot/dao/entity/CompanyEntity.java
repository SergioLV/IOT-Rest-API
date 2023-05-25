package com.emergentes.iot.dao.entity;

import com.emergentes.iot.model.Company;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "company")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "company_name", length = 255)
    private String companyName;

    @Column(name = "company_api_key", length = 255)
    private String companyApiKey;

    @OneToMany(mappedBy = "company")
    private List<LocationEntity> locations;

    public CompanyEntity() {
    }

    public CompanyEntity(Company company) {
        this.companyId = company.getCompanyId();
        this.companyName = company.getCompanyname();
        this.companyApiKey = company.getCompanyApiKey();
    }
}

