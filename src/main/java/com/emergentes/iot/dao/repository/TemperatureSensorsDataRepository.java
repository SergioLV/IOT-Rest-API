package com.emergentes.iot.dao.repository;

import com.emergentes.iot.dao.entity.TemperatureSensorsDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TemperatureSensorsDataRepository extends JpaRepository<TemperatureSensorsDataEntity, Long> {
    List<TemperatureSensorsDataEntity> findByTimestampBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

}
