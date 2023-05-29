package com.emergentes.iot.business;

import com.emergentes.iot.dao.HumiditySensorDAO;
import com.emergentes.iot.dao.SensorDAO;
import com.emergentes.iot.dao.entity.HumiditySensorsDataEntity;
import com.emergentes.iot.dao.entity.SensorEntity;
import com.emergentes.iot.exceptions.InvalidApiKeyException;
import com.emergentes.iot.model.Sensor;
import com.emergentes.iot.model.humidity.HumiditySensor;
import com.emergentes.iot.model.humidity.HumiditySensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SensorService {

    @Autowired
    private SensorDAO sensorDAO;

    @Autowired
    private HumiditySensorDAO humiditySensorDAO;

    public Sensor save(Sensor sensor){
        SensorEntity sensorEntity = new SensorEntity(sensor);
        sensorEntity.setSensorApiKey(generateApiKey());
        SensorEntity daoResponse = sensorDAO.save(sensorEntity);
        return new Sensor(daoResponse);
    }

    public void saveHumidityData(HumiditySensor humiditySensor){

        List<HumiditySensorData> humiditySensorDataList = humiditySensor.getHumiditySensorData();
        for(HumiditySensorData hsd: humiditySensorDataList){
            HumiditySensorsDataEntity humiditySensorsDataEntity = new HumiditySensorsDataEntity();
            humiditySensorsDataEntity.setSensor_id(1L);
            humiditySensorsDataEntity.setTimestamp(hsd.getDate());
            humiditySensorsDataEntity.setPercentage(hsd.getPercentage());
            humiditySensorDAO.save(humiditySensorsDataEntity);
        }
    }

    public void retrieveSensorDataByApiKey(String apiKey) throws InvalidApiKeyException {
        SensorEntity sensorEntity = sensorDAO.findSensorDataByApiKey(apiKey);
        if(sensorEntity == null){
            throw new InvalidApiKeyException("Invalid api key");
        }
    }
    private String generateApiKey(){
        return UUID.randomUUID().toString();
    }
}
