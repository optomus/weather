package com.commbank.weather.service;

import com.commbank.weather.domain.Weather;
import java.util.List;

public interface WeatherService {

  List<Weather> getWeatherReports();
}
