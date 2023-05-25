package com.emergentes.iot.model;

import com.emergentes.iot.dao.entity.LocationEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Location {
    private Long companyId;
    private String locationName;
    private String locationCountry;
    private String locationCity;
    private String locationMeta;

    public Location(){}
    public Location(LocationEntity locationEntity){
        this.companyId = locationEntity.getCompanyId();
        this.locationName = locationEntity.getLocationName();
        this.locationCountry = locationEntity.getLocationCountry();
        this.locationCity = locationEntity.getLocationCity();
        this.locationMeta = locationEntity.getLocationMeta();
    }
}
