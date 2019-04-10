package com.commbank.weather.service.simulator;

import com.commbank.weather.domain.Weather;
import com.commbank.weather.service.domain.WeatherConditionCriteria;

public interface WeatherSimulator {

  Weather simulateWeather(WeatherConditionCriteria weatherConditionCriteria);

}
