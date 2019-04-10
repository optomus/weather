package com.commbank.weather.service.simulator.adjustment;

import static org.junit.Assert.assertTrue;

import com.commbank.weather.domain.Location;
import com.commbank.weather.domain.Position;
import com.commbank.weather.domain.WeatherPredicate;
import com.commbank.weather.service.domain.WeatherConditionCriteria;
import org.junit.Test;

public class HumidityPredicateAdjustmentTest {

  private HumidityPredicateAdjustment humidityPredicateAdjustment = new HumidityPredicateAdjustment();

  @Test
  public void The_Humidity_Generated_Should_Be_Within_The_Range() {
    double max = 80;
    double min = 1;
    WeatherPredicate weatherPredicate = new WeatherPredicate(Location.Sydney);
    WeatherConditionCriteria weatherConditionCriteria = new WeatherConditionCriteria(Location.Sydney, new Position(-12.34, 89.34));
    humidityPredicateAdjustment.adjust(weatherPredicate, weatherConditionCriteria);
    assertTrue("The generated humidity should be greater or equal to lowest in range", weatherPredicate.getHumidity() >= min);
    assertTrue("The generated humidity should be lesser or equal to the highest in range", weatherPredicate.getHumidity() <= max);
  }
}
