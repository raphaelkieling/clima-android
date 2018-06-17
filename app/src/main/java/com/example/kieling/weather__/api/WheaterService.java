package com.example.kieling.weather__.api;

import com.example.kieling.weather__.Weather.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WheaterService {
    @GET("weather")
    Call<WeatherResponse> listWeather(@Query("format") String format,
                                      @Query("city_name") String cidade,
                                      @Query("key") String key);
}
