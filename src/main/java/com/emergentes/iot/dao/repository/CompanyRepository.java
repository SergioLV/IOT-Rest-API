package com.emergentes.iot.dao.repository;

import com.emergentes.iot.dao.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {
    CompanyEntity findByCompanyName(String companyName);
    CompanyEntity findByCompanyId(Long companyId);
}

