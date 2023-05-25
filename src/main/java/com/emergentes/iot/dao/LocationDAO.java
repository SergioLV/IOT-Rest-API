package com.emergentes.iot.dao;

import com.emergentes.iot.dao.entity.LocationEntity;
import com.emergentes.iot.dao.repository.LocationRepository;
import com.emergentes.iot.exceptions.CompanyLocationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class LocationDAO {

    @Autowired
    private LocationRepository locationRepository;

    @Transactional
    public void save(LocationEntity locationEntity){
        try{
            locationRepository.save(locationEntity);
        }catch(DataIntegrityViolationException e){
            throw new DataIntegrityViolationException("The location " + locationEntity.getLocationName() + " is already assigned to the company id " + locationEntity.getCompanyId().toString());
        }
    }

    @Transactional
    public LocationEntity getLocationByCompanyIdByName(Long companyId, String locationName){
        LocationEntity l = locationRepository.getLocationByCompanyIdByName(companyId, locationName);
        return locationRepository.getLocationByCompanyIdByName(companyId, locationName);
    }
}
