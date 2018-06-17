package com.example.kieling.weather__.Weather;

public class WeatherResponse {
    public WeatherResults getResults() {
        return results;
    }

    public void setResults(WeatherResults results) {
        this.results = results;
    }

    WeatherResults results;
}
