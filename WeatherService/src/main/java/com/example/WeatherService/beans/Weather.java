package com.example.WeatherService.beans;

import io.swagger.annotations.ApiModelProperty;

public class Weather {
    @ApiModelProperty(notes = "City Name", name = "ville", required = true, value = "Marseille")
    private String ville;
    @ApiModelProperty(notes = "City's zipcode", name = "zipCode", required = true, value = "13000")
    public String zipCode;
    @ApiModelProperty(notes = "City's country", name = "pays", required = true, value = "France")
    public String pays;
    @ApiModelProperty(notes = "City's weather", name = "weather", required = true, value = "SUPER BON CE SOLEIL")
    public String weather;

    public Weather(String ville, String zipCode, String pays, String weather){
        this.ville = ville;
        this.zipCode = zipCode;
        this.pays = pays;
        this.weather = weather;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "ville='" + ville + '\'' +
                ", zipCode=" + zipCode +
                ", pays='" + pays + '\'' +
                ", weather='" + weather + '\'' +
                '}';
    }

}
