package com.emergentes.iot.business;

import com.emergentes.iot.dao.AdminDAO;
import com.emergentes.iot.dao.entity.AdminEntity;
import com.emergentes.iot.exceptions.LoginException;
import com.emergentes.iot.exceptions.TokenGenerationException;
import com.emergentes.iot.model.Admin;
import com.emergentes.iot.utils.PasswordUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class AdminServiceTest {

    @InjectMocks
    private AdminService adminService;

    @Mock
    private AdminDAO adminDAO;

    @Mock
    private TokenService tokenService;

    @Test
    public void loginSuccess() throws LoginException, TokenGenerationException {
        Admin admin = new Admin("admin", "tarea3");
        String token = "token";
        when(adminDAO.getPassword(any(AdminEntity.class))).thenReturn(PasswordUtils.hashPassword(admin.getPassword()));
        when(tokenService.generateToken()).thenReturn(token);
        String resultToken = adminService.login(admin);
        assertEquals(token, resultToken);
    }

    @Test
    public void loginFailure() {
        Admin admin = new Admin("admin", "tarea3");
        when(adminDAO.getPassword(any(AdminEntity.class))).thenReturn(null);
        assertThrows(LoginException.class, () -> adminService.login(admin));
    }
}