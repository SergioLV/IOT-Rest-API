package com.emergentes.iot.dao;

import com.emergentes.iot.dao.entity.SensorEntity;
import com.emergentes.iot.dao.repository.SensorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessResourceUsageException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SensorDAO {

    @Autowired
    private SensorRepository sensorRepository;

    @Transactional
    public void save(SensorEntity sensorEntity){
        try{
            sensorRepository.save(sensorEntity);
        }catch(InvalidDataAccessResourceUsageException e){
            throw new InvalidDataAccessResourceUsageException("Company id" + sensorEntity.getSensorId() + " does not exists.");
        }
    }

    public SensorEntity getSensorBySensorNameBySensorApiKey(String sensorName, String sensorApiKey){
        return sensorRepository.findBySensorNameAndSensorApiKey(sensorName, sensorApiKey);
    }
}
