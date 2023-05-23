package com.emergentes.iot.dao.entity;

import com.emergentes.iot.model.Location;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "location")
public class LocationEntity {
    @Id
    @Column(name = "company_id")
    private Long companyId;

    @OneToOne
    @JoinColumn(name = "company_id")
    @MapsId
    private CompanyEntity company;

    @Column(name = "location_name", length = 255)
    private String locationName;

    @Column(name = "location_country", length = 255)
    private String locationCountry;

    @Column(name = "location_city", length = 255)
    private String locationCity;

    @Column(name = "location_meta", length = 255)
    private String locationMeta;

    @OneToMany(mappedBy = "location")
    private List<SensorEntity> sensors;

    public LocationEntity() {
    }

    public LocationEntity(Location location) {
        this.companyId = location.getCompanyId();
        this.locationName = location.getLocationName();
        this.locationCountry = location.getLocationCountry();
        this.locationCity = location.getLocationCity();
        this.locationMeta = location.getLocationMeta();
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public CompanyEntity getCompany() {
        return company;
    }

    public void setCompany(CompanyEntity company) {
        this.company = company;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationCountry() {
        return locationCountry;
    }

    public void setLocationCountry(String locationCountry) {
        this.locationCountry = locationCountry;
    }

    public String getLocationCity() {
        return locationCity;
    }

    public void setLocationCity(String locationCity) {
        this.locationCity = locationCity;
    }

    public String getLocationMeta() {
        return locationMeta;
    }

    public void setLocationMeta(String locationMeta) {
        this.locationMeta = locationMeta;
    }

    public List<SensorEntity> getSensors() {
        return sensors;
    }

    public void setSensors(List<SensorEntity> sensors) {
        this.sensors = sensors;
    }
}
