package com.emergentes.iot.service.api;


import com.emergentes.iot.business.*;
import com.emergentes.iot.dto.requests.*;
import com.emergentes.iot.dto.responses.*;
import com.emergentes.iot.exceptions.*;
import com.emergentes.iot.model.Admin;
import com.emergentes.iot.model.Company;
import com.emergentes.iot.model.Location;
import com.emergentes.iot.model.Sensor;
import com.emergentes.iot.model.humidity.HumiditySensor;
import com.emergentes.iot.model.temperature.TemperatureSensor;
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

    @Autowired
    private SensorService sensorService;

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

    @PostMapping(value = "/sensor")
    public ResponseEntity<SensorResponse> sensor(@RequestBody SensorRequest request, @RequestHeader("Authorization") String authorizationHeader) throws InvalidTokenException, BadCategoryException {
        if(!request.getSensorCategory().equals("Humidity") && !request.getSensorCategory().equals("Temperature")){
            throw new BadCategoryException("Category not supported");
        }
        ModelMapper modelMapper = new ModelMapper();
        Sensor sensor = modelMapper.map(request, Sensor.class);
        String authToken = authorizationHeader.substring(7);
        tokenService.checkToken(authToken);
        Sensor sensorResponse  = sensorService.save(sensor);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new SensorResponse("New Sensor added!", sensorResponse));
    }

    @PostMapping(value = "/data/humidity")
    public ResponseEntity<HumiditySensorResponse> humidityData(@RequestBody HumiditySensorRequest request) throws InvalidApiKeyException{
        ModelMapper modelMapper = new ModelMapper();
        HumiditySensor humiditySensor = modelMapper.map(request, HumiditySensor.class);
        Long sensorId = sensorService.retrieveSensorDataByApiKey(humiditySensor.getApiKey());
        humiditySensor.setSensorId(sensorId);
        sensorService.saveHumidityData(humiditySensor);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new HumiditySensorResponse("Data retreived successfully!"));
    }

    @PostMapping(value = "/data/temperature")
    public ResponseEntity<HumiditySensorResponse> temperatureData(@RequestBody TemperatureSensorRequest request) throws InvalidApiKeyException{
        ModelMapper modelMapper = new ModelMapper();
        TemperatureSensor temperatureSensor = modelMapper.map(request, TemperatureSensor.class);
        Long sensorId = sensorService.retrieveSensorDataByApiKey(temperatureSensor.getApiKey());
        temperatureSensor.setSensorId(sensorId);
        sensorService.saveTemperatureData(temperatureSensor);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(new HumiditySensorResponse("Data retreived successfully!"));
    }
}
