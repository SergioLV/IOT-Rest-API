package com.emergentes.iot.dao;

import com.emergentes.iot.dao.entity.HumiditySensorsDataEntity;
import com.emergentes.iot.dao.repository.HumiditySensorsDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class HumiditySensorDAO {

    @Autowired
    private HumiditySensorsDataRepository humiditySensorsDataRepository;

   @Transactional
    public void save(HumiditySensorsDataEntity humiditySensorsDataEntity){
        humiditySensorsDataRepository.save(humiditySensorsDataEntity);
    }

    @Transactional
    public List<HumiditySensorsDataEntity> getDataBetweenDates(LocalDateTime from, LocalDateTime to){
       return humiditySensorsDataRepository.findByTimestampBetween(from,to);
    }
}
