package com.example.kieling.weather__.Weather;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kieling.weather__.R;

import java.util.List;

public class WeatherForeactAdapter extends ArrayAdapter<WeatherForecast> {
    public WeatherForeactAdapter(@NonNull Context context, List<WeatherForecast> list) {
        super(context,0, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        WeatherForecast forecast = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(R.layout.row_item, null);

        TextView max = view.findViewById(R.id.max);
        TextView min = view.findViewById(R.id.min);
        TextView date = view.findViewById(R.id.date);
        ImageView condition = view.findViewById(R.id.condition);

        if(forecast.getCondition().equals("cloud")){
            condition.setImageResource(R.drawable.cloud);
        }
        if(forecast.getCondition().equals("cloudly_day")){
            condition.setImageResource(R.drawable.cloudsun);
        }
        if(forecast.getCondition().equals("storm")){
            condition.setImageResource(R.drawable.thunderstorm);
        }
        if(forecast.getCondition().equals("clear_day")){
            condition.setImageResource(R.drawable.sun);
        }
        if(forecast.getCondition().equals("rain")){
            condition.setImageResource(R.drawable.rain);
        }

        max.setText(forecast.max);
        min.setText(forecast.min);
        date.setText(forecast.date);

        return view;
    }
}
