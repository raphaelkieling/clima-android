# Clima Android

App de estudo com retrofit 2

## Retrofit
*main*
```java
 Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://api.hgbrasil.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
```

*service*
```java
public interface WheaterService {
    @GET("weather")
    Call<WeatherResponse> listWeather(@Query("format") String format,
                                      @Query("city_name") String cidade,
                                      @Query("key") String key);
}
```
