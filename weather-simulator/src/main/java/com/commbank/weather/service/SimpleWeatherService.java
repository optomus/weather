package com.commbank.weather.service;

import com.commbank.weather.domain.Weather;
import com.commbank.weather.service.criteria.WeatherConditionCriteriaBuilder;
import com.commbank.weather.service.domain.WeatherConditionCriteria;
import com.commbank.weather.service.simulator.SimpleWeatherSimulator;
import com.commbank.weather.service.simulator.WeatherSimulator;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a simple implementation that will provided weather simulations for a pre-defined set of locations.
 * The locations are,
 * <ul>
 *   <li>Sydney</li>
 *   <li>Melbourne</li>
 *   <li>Adelaide</li>
 *   <li>Darwin</li>
 *   <li>Perth</li>
 *   <li>Hobart</li>
 *   <li>Brisbane</li>
 *   <li>Queenstown</li>
 *   <li>Christchurch</li>
 *   <li>Auckland</li>
 *   <li>NewYork</li>
 *   <li>LosAngeles</li>
 * </ul>
 *
 * This implementation will utilise the {@link WeatherSimulator} to generate simulated weather
 * conditions for the above given locations.
 */
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
