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
    public SensorEntity save(SensorEntity sensorEntity){
        try{
            return sensorRepository.save(sensorEntity);
        }catch(InvalidDataAccessResourceUsageException e){
            throw new InvalidDataAccessResourceUsageException("Company id" + sensorEntity.getSensorId() + " does not exists.");
        }
    }

    @Transactional
    public SensorEntity findById(int id){
        return sensorRepository.findBySensorId((long) id);
    }


    public SensorEntity findSensorByApiKey(String apiKey){
        return sensorRepository.findBySensorApiKey(apiKey);
    }
}
