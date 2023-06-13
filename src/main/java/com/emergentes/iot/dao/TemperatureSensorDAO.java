package com.emergentes.iot.dao;

import com.emergentes.iot.dao.entity.HumiditySensorsDataEntity;
import com.emergentes.iot.dao.entity.TemperatureSensorsDataEntity;
import com.emergentes.iot.dao.repository.TemperatureSensorsDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class TemperatureSensorDAO {

    @Autowired
    private TemperatureSensorsDataRepository temperatureSensorsDataRepository;

    @Transactional
    public void save(TemperatureSensorsDataEntity temperatureSensorsDataEntity){
        temperatureSensorsDataRepository.save(temperatureSensorsDataEntity);
    }

    @Transactional
    public List<TemperatureSensorsDataEntity> getDataBetweenDates(LocalDateTime from, LocalDateTime to){
        return temperatureSensorsDataRepository.findByTimestampBetween(from,to);
    }

}
