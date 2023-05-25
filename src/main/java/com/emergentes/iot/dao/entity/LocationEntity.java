package com.emergentes.iot.dao.entity;

import com.emergentes.iot.model.Location;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
@Table(name = "location")
public class LocationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long locationId;

    @Column(name = "company_id")
    private Long companyId;

    @Column(name = "location_name", length = 255)
    private String locationName;

    @Column(name = "location_country", length = 255)
    private String locationCountry;

    @Column(name = "location_city", length = 255)
    private String locationCity;

    @Column(name = "location_meta", length = 255)
    private String locationMeta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private CompanyEntity company;

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

}
