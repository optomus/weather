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
