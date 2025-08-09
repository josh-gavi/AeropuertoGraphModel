package ec.edu.espol.model;

public class Aeropuerto {

    private String code;
    private String name;
    private String city;
    private String country;
    private double latitude;
    private double longitude;


    public Aeropuerto(String code, String name, String city, String country, double latitude, double longitude) {
        this.code = code;
        this.name = name;
        this.city = city;
        this.country = country;
        this.latitude = latitude;
        this.longitude = longitude;
    }


    public String getCode() {
        return code;
    }


    public String getName() {
        return name;
    }


    public String getCity() {
        return city;
    }


    public String getCountry() {
        return country;
    }


    public double getLatitude() {
        return latitude;
    }


    public double getLongitude() {
        return longitude;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public void setName(String name) {
        this.name = name;
    }


    public void setCity(String city) {
        this.city = city;
    }


    public void setCountry(String country) {
        this.country = country;
    }


    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }


    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    
    




}
