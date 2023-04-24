package org.example.pojos;

public class ZipCodePojo {
    private String cityName;
    private String state;
    private String zipCode;
    private String longitude;
    private String latitude;

    public ZipCodePojo(String cityName, String state, String zipCode, String longitude, String latitude) {
        this.cityName = cityName;
        this.state = state;
        this.zipCode = zipCode;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String generateGoogleMapsLink() {
        return String.format("https://www.google.com/maps/search/?api=1&query=%s,%s", latitude, longitude);
    }
}
