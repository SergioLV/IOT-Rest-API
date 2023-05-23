package com.emergentes.iot.business;

import com.emergentes.iot.dao.CompanyDAO;
import com.emergentes.iot.dao.entity.CompanyEntity;
import com.emergentes.iot.model.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CompanyService {
    @Autowired
    private CompanyDAO companyDAO;

    public String save(Company company){
        String apikey = generateApiKey();
        company.setCompanyApiKey(apikey);
        CompanyEntity companyEntity = new CompanyEntity(company);
        companyDAO.save(companyEntity);
        return apikey;
    }

    private String generateApiKey(){
        return UUID.randomUUID().toString();
    }
}
