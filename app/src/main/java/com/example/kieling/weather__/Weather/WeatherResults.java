package com.example.kieling.weather__.Weather;

import java.util.List;

public class WeatherResults {
    public List<WeatherForecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<WeatherForecast> results) {
        this.forecast = results;
    }
    String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    List<WeatherForecast> forecast;
}
