package com.example.kieling.weather__;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.kieling.weather__.Weather.WeatherForeactAdapter;
import com.example.kieling.weather__.Weather.WeatherForecast;
import com.example.kieling.weather__.Weather.WeatherResponse;
import com.example.kieling.weather__.Weather.WeatherResults;
import com.example.kieling.weather__.api.WheaterService;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    ListView listWeather;
    TextView textCidade;
    Button encontrarBotao;
    ArrayList<WeatherForecast> forecastsArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listWeather = findViewById(R.id.listWeather);
        textCidade = findViewById(R.id.cidade);
        encontrarBotao =findViewById(R.id.encontrarBotao);
        forecastsArray = new ArrayList<>();

        encontrarBotao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getweather();
            }
        });

    }

    protected  void getweather() {
        forecastsArray.clear();
        final HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(logging);  // <-- this is the important line!
        Log.d("NOME CIDADE",textCidade.getText().toString());
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl("https://api.hgbrasil.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        WheaterService service = retrofit.create(WheaterService.class);

        Call<WeatherResponse> call = service.listWeather("json",textCidade.getText().toString(),"4aaa9ac3");

        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                WeatherResults results= response.body().getResults();
                List<WeatherForecast> forecast = results.getForecast();



                if(!forecast.isEmpty()){
                    for(WeatherForecast fore:forecast){
                        forecastsArray.add(fore);
                    }
                }

                listWeather.setAdapter(new WeatherForeactAdapter(MainActivity.this,forecastsArray));
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {

            }
        });
    }
}
