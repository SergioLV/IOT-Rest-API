package com.emergentes.iot.service.api;


import com.emergentes.iot.business.AdminService;
import com.emergentes.iot.business.CompanyService;
import com.emergentes.iot.business.LocationService;
import com.emergentes.iot.business.TokenService;
import com.emergentes.iot.dto.requests.CompanyRequest;
import com.emergentes.iot.dto.requests.LocationRequest;
import com.emergentes.iot.dto.requests.LoginRequest;
import com.emergentes.iot.dto.responses.CompanyResponse;
import com.emergentes.iot.dto.responses.LocationResponse;
import com.emergentes.iot.dto.responses.LoginResponse;
import com.emergentes.iot.exceptions.*;
import com.emergentes.iot.model.Admin;
import com.emergentes.iot.model.Company;
import com.emergentes.iot.model.Location;
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

    @Autowired
    private LocationService locationService;

    @PostMapping(value = "/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) throws LoginException, TokenGenerationException {

        ModelMapper modelMapper = new ModelMapper();
        Admin admin = modelMapper.map(request, Admin.class);
        String token = adminService.login(admin);
        LoginResponse loginResponse = new LoginResponse(token, 3600);
        return ResponseEntity.status(HttpStatus.OK).body(loginResponse);
    }

    @PostMapping(value = "/company")
    public ResponseEntity<CompanyResponse> companies(@RequestBody CompanyRequest request, @RequestHeader("Authorization") String authorizationHeader) throws InvalidTokenException {
        ModelMapper modelMapper = new ModelMapper();
        Company company = modelMapper.map(request, Company.class);
        String authToken = authorizationHeader.substring(7);
        tokenService.checkToken(authToken);
        Company cr = companyService.save(company);
        CompanyResponse companyResponse = new CompanyResponse( "New company added!",cr);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(companyResponse);
    }

    @PostMapping(value = "/location")
    public ResponseEntity<LocationResponse> location(@RequestBody LocationRequest request, @RequestHeader("X-Api-Key") String apiKey) throws InvalidCompanyIdException, InvalidApiKeyException {
        ModelMapper modelMapper = new ModelMapper();
        Location location = modelMapper.map(request, Location.class);
        companyService.checkApiKey(request.getCompanyId(), apiKey);
        Long locationId = locationService.save(location);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new LocationResponse("New Location Added!", locationId));
    }


}
