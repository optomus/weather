package com.commbank.weather.service.simulator.adjustment;

import static com.commbank.weather.service.util.WeatherUtil.randomNumber;

import com.commbank.weather.domain.WeatherPredicate;
import com.commbank.weather.service.domain.WeatherConditionCriteria;
import java.time.ZonedDateTime;

public class TemperaturePredicateAdjustment implements WeatherPredicateAdjustment {

  private static double _4AM = 4;
  private static double _10AM = 10;
  private static double _5PM = 17;

  public void adjust(WeatherPredicate weatherPredicate,
      WeatherConditionCriteria weatherConditionCriteria) {
    final ZonedDateTime localDateTime = weatherPredicate.getLocalDateTime();
    int hour = localDateTime.getHour();

    double minTemp, maxTemp;

    if (hour <= _4AM) {
      minTemp = 8;
      maxTemp = 20;
    } else if (hour <= _10AM) {
      minTemp = 21;
      maxTemp = 28;
    } else if (hour <= _5PM) {
      minTemp = 22;
      maxTemp = 38;
    } else {
      minTemp = 8;
      maxTemp = 18;
    }

    double temperature = randomNumber(maxTemp, minTemp);
    weatherPredicate.setTemperature(temperature);
  }
}
