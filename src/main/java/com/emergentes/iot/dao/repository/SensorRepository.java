package com.emergentes.iot.dao.repository;

import com.emergentes.iot.dao.entity.SensorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<SensorEntity, Integer> {
    SensorEntity findBySensorNameAndSensorApiKey(String sensorName, String sensorApiKey);
}
