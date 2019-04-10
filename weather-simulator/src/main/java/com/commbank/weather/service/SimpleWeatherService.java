package com.commbank.weather.service;

import com.commbank.weather.domain.Weather;
import com.commbank.weather.service.criteria.WeatherConditionCriteriaBuilder;
import com.commbank.weather.service.domain.WeatherConditionCriteria;
import com.commbank.weather.service.simulator.SimpleWeatherSimulator;
import com.commbank.weather.service.simulator.WeatherSimulator;
import java.util.ArrayList;
import java.util.List;

public class SimpleWeatherService implements WeatherService {

  private WeatherSimulator weatherSimulator;

  public SimpleWeatherService() {
    this.weatherSimulator = new SimpleWeatherSimulator();
  }

  public List<Weather> getWeatherReports() {
    final List<Weather> weathers = new ArrayList<>();

    for (WeatherConditionCriteria weatherConditionCriteria : weatherCriteria()) {
      weathers.add(weatherSimulator.simulateWeather(weatherConditionCriteria));
    }

    return weathers;
  }

  private List<WeatherConditionCriteria> weatherCriteria() {
    return
        WeatherConditionCriteriaBuilder.build()
            .addSydney()
            .addMelbourne()
            .addAdelaide()
            .addDarwin()
            .addPerth()
            .addHobart()
            .addBrisbane()
            .addQueensTown()
            .addChristchurch()
            .addAuckland()
            .addNewYork()
            .addLosAngelos()
            .collectWeatherConditionCriteria();

  }

}
