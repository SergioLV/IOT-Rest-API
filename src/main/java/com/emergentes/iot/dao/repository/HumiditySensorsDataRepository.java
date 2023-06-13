package com.emergentes.iot.dao.repository;

import com.emergentes.iot.dao.entity.HumiditySensorsDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface HumiditySensorsDataRepository extends JpaRepository<HumiditySensorsDataEntity, Long> {
    List<HumiditySensorsDataEntity> findByTimestampBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

}