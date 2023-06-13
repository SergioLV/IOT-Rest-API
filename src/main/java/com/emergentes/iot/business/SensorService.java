package com.emergentes.iot.business;

import com.emergentes.iot.dao.HumiditySensorDAO;
import com.emergentes.iot.dao.SensorDAO;
import com.emergentes.iot.dao.TemperatureSensorDAO;
import com.emergentes.iot.dao.entity.HumiditySensorsDataEntity;
import com.emergentes.iot.dao.entity.SensorEntity;
import com.emergentes.iot.dao.entity.TemperatureSensorsDataEntity;
import com.emergentes.iot.dto.requests.SensorDataRequest;
import com.emergentes.iot.exceptions.InvalidApiKeyException;
import com.emergentes.iot.model.Sensor;
import com.emergentes.iot.model.humidity.HumiditySensor;
import com.emergentes.iot.model.humidity.HumiditySensorData;
import com.emergentes.iot.model.temperature.TemperatureSensor;
import com.emergentes.iot.model.temperature.TemperatureSensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

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
//TODO: Refactor this
    public Map<String, List<Map<String, Object>>> retreiveBulkSensorData(SensorDataRequest request){
        Map<String, List<Map<String, Object>>> dataMap = new HashMap<>();
        List<Map<String, Object>> humidityList = new ArrayList<>();
        List<Map<String, Object>> temperatureList = new ArrayList<>();
        for(int id: request.getSensorsId()){
            String category = checkSensorCategory(id);
            if(category.equals("Humidity")){
                LocalDateTime from = convertEpochToLocalDateTime(request.getFrom());
                LocalDateTime to = convertEpochToLocalDateTime(request.getTo());
                List<HumiditySensorsDataEntity> humidityDataBetweenDates = humiditySensorDAO.getDataBetweenDates(from, to);
                Map<String, Object> humidityData = new HashMap<>();
                humidityData.put("id", id);
                humidityData.put("data", humidityDataBetweenDates);
                humidityList.add(humidityData);
            }
            if(category.equals("Temperature")){
                LocalDateTime from = convertEpochToLocalDateTime(request.getFrom());
                LocalDateTime to = convertEpochToLocalDateTime(request.getTo());
                List<TemperatureSensorsDataEntity> temperatureDataBetweenDates = temperatureSensorDAO.getDataBetweenDates(from, to);
                Map<String, Object> temperatureData = new HashMap<>();
                temperatureData.put("id", id);
                temperatureData.put("data", temperatureDataBetweenDates);
                temperatureList.add(temperatureData);
            }

        }
        dataMap.put("humidity", humidityList);
        dataMap.put("temperature", temperatureList);
        return dataMap;
    }


    private String checkSensorCategory(int id){
        SensorEntity sensorEntity = sensorDAO.findById(id);
        if(sensorEntity == null){
            return "";
        }
        return sensorEntity.getSensorCategory();
    }
    private LocalDateTime convertEpochToLocalDateTime(long epochTimestamp) {
        Instant instant = Instant.ofEpochSecond(epochTimestamp);
        return LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
    }
    private String generateApiKey(){
        return UUID.randomUUID().toString();
    }
}
