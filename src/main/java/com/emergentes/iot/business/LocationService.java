package com.emergentes.iot.business;

import com.emergentes.iot.dao.LocationDAO;
import com.emergentes.iot.dao.entity.LocationEntity;
import com.emergentes.iot.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService {

    @Autowired
    private LocationDAO locationDAO;

    public Long save(Location location){
        LocationEntity locationEntity = new LocationEntity(location);
        Long response = locationDAO.save(locationEntity);
        return response;
    }
}
