package com.emergentes.iot.model;



public class Sensor {
    private Long sensorId;

    private Location location;
    private String sensorName;
    private String sensorCategory;
    private String sensorMeta;
    private String sensorApiKey;

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getSensorCategory() {
        return sensorCategory;
    }

    public void setSensorCategory(String sensorCategory) {
        this.sensorCategory = sensorCategory;
    }

    public String getSensorMeta() {
        return sensorMeta;
    }

    public void setSensorMeta(String sensorMeta) {
        this.sensorMeta = sensorMeta;
    }

    public String getSensorApiKey() {
        return sensorApiKey;
    }

    public void setSensorApiKey(String sensorApiKey) {
        this.sensorApiKey = sensorApiKey;
    }

}
