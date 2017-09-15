package com.andigeeky.weatherapp.service;

import com.andigeeky.weatherapp.common.Constants;
import com.andigeeky.weatherapp.service.pojo.CurrentWeather;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import static com.andigeeky.weatherapp.common.Constants.URL_CURRENT_WEATHER;

/**
 * Created by e066733 on 15/09/17.
 */

public interface WeatherService {
    @GET(URL_CURRENT_WEATHER)
    Call<CurrentWeather> currentWeather(@Query(Constants.KEY_CITY) String cityName);
}
