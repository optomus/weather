package com.commbank.weather.service.simulator;

import com.commbank.weather.domain.Weather;
import com.commbank.weather.domain.WeatherCondition;
import com.commbank.weather.domain.WeatherPredicate;
import com.commbank.weather.service.domain.WeatherConditionCriteria;
import com.commbank.weather.service.simulator.adjustment.DateTimePredicateAdjustment;
import com.commbank.weather.service.simulator.adjustment.HumidityPredicateAdjustment;
import com.commbank.weather.service.simulator.adjustment.PositionPredicateAdjustment;
import com.commbank.weather.service.simulator.adjustment.PressurePredicateAdjustment;
import com.commbank.weather.service.simulator.adjustment.TemperaturePredicateAdjustment;
import com.commbank.weather.service.simulator.adjustment.WeatherPredicateAdjustment;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a simple implementation of a weather simulator.
 *
 * This implementation will randomly adjust variables used to forecast a weather condition. The variable that are adjusted are listed below.
 *
 * <ul>
 *   <li>Position. This included adjustment of latitude, longitude and elevation. Refer {@link PositionPredicateAdjustment}</li>
 *   <li>DateTime. The date time will be adjusted given a range of days. Refer {@link DateTimePredicateAdjustment}</li>
 *   <li>Temperature. The temperature will be adjusted based on different time range. Refer {@link TemperaturePredicateAdjustment}</li>
 *   <li>Humidity. The humidity will be adjusted randomly within give a range. Refer {@link HumidityPredicateAdjustment}</li>
 *   <li>Pressure. The pressure will be adjusted randomly within a given range. Refer {@link PressurePredicateAdjustment}</li>
 * </ul>
 *
 * The adjustments are carried out in an order. The order is listed below.
 *
 * <ol>
 *   <li>Position</li>
 *   <li>DateTime</li>
 *   <li>Temperature</li>
 *   <li>Humidity</li>
 *   <li>Pressure</li>
 * </ol>
 *
 * The weather condition {@link WeatherCondition} will be predicted based on the resulting temperature.
 */
public class SimpleWeatherSimulator implements WeatherSimulator {

  private List<WeatherPredicateAdjustment> adjustments = new ArrayList<>();

  public SimpleWeatherSimulator() {
    this.adjustments.add(new PositionPredicateAdjustment());
    this.adjustments.add(new DateTimePredicateAdjustment());
    this.adjustments.add(new TemperaturePredicateAdjustment());
    this.adjustments.add(new HumidityPredicateAdjustment());
    this.adjustments.add(new PressurePredicateAdjustment());
  }

  public Weather simulateWeather(WeatherConditionCriteria weatherConditionCriteria) {
    final WeatherPredicate weatherPredicate = new WeatherPredicate(weatherConditionCriteria.getLocation());

    for (WeatherPredicateAdjustment adjustment : adjustments) {
      adjustment.adjust(weatherPredicate, weatherConditionCriteria);
    }

    return predictWeather(weatherPredicate);
  }

  private Weather predictWeather(WeatherPredicate weatherPredicate) {
    WeatherCondition weatherCondition;

    if (weatherPredicate.getTemperature() > 22) {
      weatherCondition = WeatherCondition.Sunny;
    } else if (weatherPredicate.getTemperature() < 4) {
      weatherCondition = WeatherCondition.Snow;
    } else {
      weatherCondition = WeatherCondition.Cloudy;
      if (weatherPredicate.getHumidity() > 60) {
        weatherCondition = WeatherCondition.Rain;
      }
    }
    return new Weather(weatherCondition, weatherPredicate);
  }

}
