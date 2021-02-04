package br.com.dnc.pmcheatweb.dto.pontomais.register;

public class TimeCard {

    public Double latitude;
    public Double longitude;
    public String address;
    public String reference_id;
    public Boolean location_edited;

    public TimeCard(){}

    public TimeCard(Double latitude, Double longitude, String address, String reference_id,
        Boolean location_edited) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.reference_id = reference_id;
        this.location_edited = location_edited;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReference_id() {
        return reference_id;
    }

    public void setReference_id(String reference_id) {
        this.reference_id = reference_id;
    }

    public boolean isLocation_edited() {
        return location_edited;
    }

    public void setLocation_edited(boolean location_edited) {
        this.location_edited = location_edited;
    }
}
