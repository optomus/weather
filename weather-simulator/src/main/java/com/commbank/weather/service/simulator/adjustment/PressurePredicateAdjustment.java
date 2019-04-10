package com.commbank.weather.service.simulator.adjustment;

import static com.commbank.weather.service.util.WeatherUtil.randomNumber;

import com.commbank.weather.domain.WeatherPredicate;
import com.commbank.weather.service.domain.WeatherConditionCriteria;

public class PressurePredicateAdjustment implements WeatherPredicateAdjustment {

  /**
   * https://www.worldweatheronline.com/lang/en-au/sydney-weather-averages/new-south-wales/au.aspx
   */
  private static double MAX_AVERAGE_PRESSURE = 1022;
  private static double MIN_AVERAGE_PRESSURE = 1010;

  public void adjust(WeatherPredicate weatherPredicate,
      WeatherConditionCriteria weatherConditionCriteria) {
    double pressure = randomNumber(MAX_AVERAGE_PRESSURE, MIN_AVERAGE_PRESSURE);
    weatherPredicate.setPressure(pressure);

  }
}
