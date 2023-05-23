package com.emergentes.iot.dao;

import com.emergentes.iot.dao.entity.CompanyEntity;
import com.emergentes.iot.dao.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyDAO {

    @Autowired
    private CompanyRepository companyRepository;

    public void save(CompanyEntity companyEntity){
        companyRepository.save(companyEntity);
    }
}
