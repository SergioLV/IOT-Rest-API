package com.emergentes.iot.dao;

import com.emergentes.iot.dao.entity.AdminEntity;
import com.emergentes.iot.dao.repository.AdminRepository;
import com.emergentes.iot.model.Admin;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;


import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@DataJpaTest
@Import(AdminDAO.class)
class AdminDAOTest {

    @Autowired
    private AdminDAO adminDAO;

    @Mock
    private AdminRepository adminRepository;

    @BeforeEach
    void setUp(){
        Admin admin = new Admin("admin", "511bc56250dfd22b78f2aa0fc18959fe2c661a5441d0053ddcfe30fd4834018460b8bb840b9d4f0024a15313958b8a81ad57c05fc6791f89ede299cfead3297e");
        AdminEntity adminEntity = new AdminEntity(admin);
        adminDAO.save(adminEntity);
    }

    @Test
    void getPassword() {
        String username = "admin";
        String hashedPassword = "511bc56250dfd22b78f2aa0fc18959fe2c661a5441d0053ddcfe30fd4834018460b8bb840b9d4f0024a15313958b8a81ad57c05fc6791f89ede299cfead3297e";
        AdminEntity adminEntity = new AdminEntity();
        adminEntity.setUsername(username);
        adminEntity.setPassword(hashedPassword);
        when(adminRepository.findById(any(String.class))).thenReturn(Optional.of(new AdminEntity(username, hashedPassword)));

        String password = adminDAO.getPassword(adminEntity);
        assertEquals(hashedPassword, password);
    }
}