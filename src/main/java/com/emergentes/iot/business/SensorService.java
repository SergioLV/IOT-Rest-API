package com.emergentes.iot.business;

import com.emergentes.iot.dao.HumiditySensorDAO;
import com.emergentes.iot.dao.SensorDAO;
import com.emergentes.iot.dao.TemperatureSensorDAO;
import com.emergentes.iot.dao.entity.HumiditySensorsDataEntity;
import com.emergentes.iot.dao.entity.SensorEntity;
import com.emergentes.iot.dao.entity.TemperatureSensorsDataEntity;
import com.emergentes.iot.exceptions.InvalidApiKeyException;
import com.emergentes.iot.model.Sensor;
import com.emergentes.iot.model.humidity.HumiditySensor;
import com.emergentes.iot.model.humidity.HumiditySensorData;
import com.emergentes.iot.model.temperature.TemperatureSensor;
import com.emergentes.iot.model.temperature.TemperatureSensorData;
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

    @Autowired
    private TemperatureSensorDAO temperatureSensorDAO;

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
            humiditySensorsDataEntity.setSensor_id(humiditySensor.getSensorId());
            humiditySensorsDataEntity.setTimestamp(hsd.getDate());
            humiditySensorsDataEntity.setPercentage(hsd.getPercentage());
            humiditySensorDAO.save(humiditySensorsDataEntity);
        }
    }

    public void saveTemperatureData(TemperatureSensor temperatureSensor){
        List<TemperatureSensorData> temperatureSensorDataList = temperatureSensor.getTemperatureSensorData();
        for(TemperatureSensorData tsd: temperatureSensorDataList){
            TemperatureSensorsDataEntity temperatureSensorsDataEntity = new TemperatureSensorsDataEntity();
            temperatureSensorsDataEntity.setSensorId(temperatureSensor.getSensorId());
            temperatureSensorsDataEntity.setTimestamp(tsd.getDate());
            temperatureSensorsDataEntity.setTemperature(tsd.getTemperature());
            temperatureSensorDAO.save(temperatureSensorsDataEntity);
        }
    }

    public Long retrieveSensorByApiKey(String apiKey) throws InvalidApiKeyException {
        SensorEntity sensorEntity = sensorDAO.findSensorByApiKey(apiKey);
        if(sensorEntity == null){
            throw new InvalidApiKeyException("Invalid api key");
        }
        return sensorEntity.getSensorId();
    }

    public void retreiveBulkSensorData()
    private String generateApiKey(){
        return UUID.randomUUID().toString();
    }
}
