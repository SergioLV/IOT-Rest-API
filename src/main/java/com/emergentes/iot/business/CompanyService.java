package com.emergentes.iot.business;

import com.emergentes.iot.dao.CompanyDAO;
import com.emergentes.iot.dao.entity.CompanyEntity;
import com.emergentes.iot.exceptions.CompanyLocationException;
import com.emergentes.iot.exceptions.InvalidApiKeyException;
import com.emergentes.iot.exceptions.InvalidCompanyIdException;
import com.emergentes.iot.model.Company;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CompanyService {
    @Autowired
    private CompanyDAO companyDAO;

    public Company save(Company company){
        String apikey = generateApiKey();
        company.setCompanyApiKey(apikey);
        CompanyEntity companyEntity = new CompanyEntity(company);
        companyDAO.save(companyEntity);
        return getCompanyIdByName(companyEntity.getCompanyName());
    }

    private Company getCompanyIdByName(String company_name){
        ModelMapper modelMapper = new ModelMapper();
        Company company = modelMapper.map(companyDAO.getCompanyByName(company_name), Company.class);
        return company;
    }

    public void checkApiKey(Long companyId, String apiKey) throws InvalidCompanyIdException, InvalidApiKeyException{
        CompanyEntity company = companyDAO.getCompanyById(companyId);
        if(company == null){
            throw new InvalidCompanyIdException(companyId.toString());
        }

        if(!apiKey.equals(company.getCompanyApiKey())){
            throw new InvalidApiKeyException("Invalid api key");
        }
    }

    private String generateApiKey(){
        return UUID.randomUUID().toString();
    }
}
