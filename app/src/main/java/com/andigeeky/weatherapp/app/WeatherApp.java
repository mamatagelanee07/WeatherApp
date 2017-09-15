package com.andigeeky.weatherapp.app;

import android.app.Application;
import android.util.Log;

import com.andigeeky.weatherapp.service.WeatherService;
import com.andigeeky.weatherapp.service.pojo.CurrentWeather;
import com.andigeeky.weatherapp.service.pojo.Weather;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by e066733 on 15/09/17.
 */

public class WeatherApp extends Application {

    public static final String TAG = WeatherApp.class.getSimpleName();
    @Override
    public void onCreate() {
        super.onCreate();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        WeatherService service = retrofit.create(WeatherService.class);
        Call<CurrentWeather> currentWeather = service.currentWeather("London");
        currentWeather.enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                Log.i(TAG, response.body().toString());
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                Log.i(TAG, t.getLocalizedMessage());
            }
        });
    }
}
