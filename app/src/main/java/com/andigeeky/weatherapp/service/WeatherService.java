package com.andigeeky.weatherapp.service;

import com.andigeeky.weatherapp.BuildConfig;
import com.andigeeky.weatherapp.service.pojo.CurrentWeather;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by e066733 on 15/09/17.
 */

public interface WeatherService {
    @GET("data/2.5/weather?APPID="+ BuildConfig.API_KEY)
    Call<CurrentWeather> currentWeather(@Query("q") String cityName);
}
