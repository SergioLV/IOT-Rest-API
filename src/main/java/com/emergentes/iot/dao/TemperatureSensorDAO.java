package com.emergentes.iot.dao;

import com.emergentes.iot.dao.entity.TemperatureSensorsDataEntity;
import com.emergentes.iot.dao.repository.TemperatureSensorsDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TemperatureSensorDAO {

    @Autowired
    private TemperatureSensorsDataRepository temperatureSensorsDataRepository;

    public void save(TemperatureSensorsDataEntity temperatureSensorsDataEntity){
        temperatureSensorsDataRepository.save(temperatureSensorsDataEntity);
    }
}
