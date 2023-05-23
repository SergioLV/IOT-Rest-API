package com.emergentes.iot.dao;

import com.emergentes.iot.dao.entity.AdminEntity;
import com.emergentes.iot.dao.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AdminDAO {

    @Autowired
    private AdminRepository adminRepository;

    public String getPassword(AdminEntity adminEntity) {
        AdminEntity foundAdminEntity = getAdminEntityByUsername(adminEntity.getUsername());
        return (foundAdminEntity != null) ? foundAdminEntity.getPassword() : null;
    }

    private AdminEntity getAdminEntityByUsername(String username) {
        return adminRepository.findById(username).orElse(null);
    }
}
