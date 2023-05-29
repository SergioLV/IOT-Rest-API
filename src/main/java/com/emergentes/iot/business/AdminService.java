package com.emergentes.iot.business;

import com.emergentes.iot.dao.AdminDAO;
import com.emergentes.iot.dao.entity.AdminEntity;
import com.emergentes.iot.exceptions.LoginException;
import com.emergentes.iot.exceptions.TokenGenerationException;
import com.emergentes.iot.model.Admin;
import com.emergentes.iot.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    private AdminDAO adminDAO;

    @Autowired
    private TokenService tokenService;

    public String login(Admin admin) throws LoginException, TokenGenerationException {
        String hashedPassword = PasswordUtils.hashPassword(admin.getPassword());
        admin.setPassword(hashedPassword);
        if (!checkPassword(admin)) {
            throw new LoginException("Invalid credentials");
        }
        return tokenService.generateToken();
    }

    private boolean checkPassword(Admin admin) {
        AdminEntity adminEntity = new AdminEntity(admin);
        String storedPassword = adminDAO.getPassword(adminEntity);
        return storedPassword != null && storedPassword.equals(admin.getPassword());
    }
}
