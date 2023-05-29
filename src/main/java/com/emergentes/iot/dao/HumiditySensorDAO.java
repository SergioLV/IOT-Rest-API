package com.emergentes.iot.dao;

import com.emergentes.iot.dao.entity.HumiditySensorsDataEntity;
import com.emergentes.iot.dao.repository.HumiditySensorsDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HumiditySensorDAO {

    @Autowired
    private HumiditySensorsDataRepository humiditySensorsDataRepository;

    public void save(HumiditySensorsDataEntity humiditySensorsDataEntity){
        humiditySensorsDataRepository.save(humiditySensorsDataEntity);
    }
}
