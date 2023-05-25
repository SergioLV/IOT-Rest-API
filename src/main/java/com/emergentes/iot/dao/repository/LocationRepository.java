package com.emergentes.iot.dao.repository;

import com.emergentes.iot.dao.entity.LocationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<LocationEntity, Integer> {
    @Query("SELECT l FROM LocationEntity l WHERE l.company.companyId = :companyId AND l.locationName = :locationName")
    LocationEntity getLocationByCompanyIdByName(@Param("companyId") Long companyId, @Param("locationName") String locationName);

//    TODO: SELECT * FROM location WHERE company_id = <company_id> AND location_name = '<location_name>';
//  If there is any duplicated value, the db gets a phantom insertion and the serial gets added 1. a query like
//    that should help to manage from the application logic the not-insertion when there is a duplicated value.
// TODO: Change the tables behavior.
}
