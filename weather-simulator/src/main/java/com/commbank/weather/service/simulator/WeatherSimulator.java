package com.commbank.weather.service.simulator;

import com.commbank.weather.domain.Weather;
import com.commbank.weather.service.domain.WeatherConditionCriteria;

/**
 * This service will provide generate a simulated weather for a given set of criteria that influence
 * a weather condition.
 */
public interface WeatherSimulator {

  Weather simulateWeather(WeatherConditionCriteria weatherConditionCriteria);

}
