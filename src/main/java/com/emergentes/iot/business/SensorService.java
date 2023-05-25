package com.emergentes.iot.business;

import com.emergentes.iot.dao.SensorDAO;
import com.emergentes.iot.dao.entity.SensorEntity;
import com.emergentes.iot.model.Sensor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.UUID;

@Service
public class SensorService {

    @Autowired
    private SensorDAO sensorDAO;

    public Sensor save(Sensor sensor){
        SensorEntity sensorEntity = new SensorEntity(sensor);
        sensorEntity.setSensorApiKey(generateApiKey());
        sensorDAO.save(sensorEntity);
        return getSensorBySensorNameBySensorId(sensorEntity.getSensorName(), sensorEntity.getSensorApiKey());
    }

    private Sensor getSensorBySensorNameBySensorId(String sensorName, String sensorApiKey){
        ModelMapper modelMapper = new ModelMapper();
        Sensor sensor = modelMapper.map(sensorDAO.getSensorBySensorNameBySensorApiKey(sensorName, sensorApiKey), Sensor.class);
        return sensor;
    }

    private String generateApiKey(){
        return UUID.randomUUID().toString();
    }
}
