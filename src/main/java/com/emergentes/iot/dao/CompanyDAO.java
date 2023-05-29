package com.emergentes.iot.dao;

import com.emergentes.iot.dao.entity.CompanyEntity;
import com.emergentes.iot.dao.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class CompanyDAO {

    @Autowired
    private CompanyRepository companyRepository;

    @Transactional
    public void save(CompanyEntity companyEntity){
        try {
            companyRepository.save(companyEntity);
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("The company " + companyEntity.getCompanyName() + " already exists.");
        }
    }
    @Transactional
    public CompanyEntity getCompanyByName(String company_name){
        return companyRepository.findByCompanyName(company_name);
    }

    @Transactional
    public CompanyEntity getCompanyById(Long companyId){
        return companyRepository.findByCompanyId(companyId);
    }

}
