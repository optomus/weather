package com.commbank.weather.service;

import com.commbank.weather.domain.Weather;
import java.util.List;

/**
 * This service will provide simulated weather conditions for a pre-defined set of locations.
 *
 * The weather conditions are simulated by randomising the variable contributing to forecast weather.
 */
public interface WeatherService {

  List<Weather> getWeatherReports();
}
