package com.emergentes.iot.service.api;


import com.emergentes.iot.business.AdminService;
import com.emergentes.iot.business.CompanyService;
import com.emergentes.iot.business.TokenService;
import com.emergentes.iot.dto.requests.CompanyRequest;
import com.emergentes.iot.dto.requests.LoginRequest;
import com.emergentes.iot.dto.responses.CompanyResponse;
import com.emergentes.iot.dto.responses.LoginResponse;
import com.emergentes.iot.exceptions.InvalidTokenException;
import com.emergentes.iot.exceptions.LoginException;
import com.emergentes.iot.exceptions.TokenGenerationException;
import com.emergentes.iot.model.Admin;
import com.emergentes.iot.model.Company;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
public class IotController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private TokenService tokenService;

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) throws LoginException, TokenGenerationException {

        ModelMapper modelMapper = new ModelMapper();
        Admin admin = modelMapper.map(request, Admin.class);
        String token = adminService.login(admin);
        LoginResponse loginResponse = new LoginResponse(token, 3600);
        return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
    }

    @PostMapping(value = "/company")
    public ResponseEntity<CompanyResponse> companies(@RequestBody CompanyRequest request, HttpServletRequest httpServletRequest) throws InvalidTokenException {
        ModelMapper modelMapper = new ModelMapper();


        Company company = modelMapper.map(request, Company.class);
        String authToken = httpServletRequest.getHeader("Authorization").substring(7);
        tokenService.checkToken(authToken);
        String apikey = companyService.save(company);

        CompanyResponse companyResponse = new CompanyResponse("New company added!", apikey);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(companyResponse);

    }


}
