package com.commbank.weather.service.simulator.adjustment;

import static org.junit.Assert.assertTrue;

import com.commbank.weather.domain.Location;
import com.commbank.weather.domain.Position;
import com.commbank.weather.domain.WeatherPredicate;
import com.commbank.weather.service.domain.WeatherConditionCriteria;
import org.junit.Test;

public class PressurePredicateAdjustmentTest {

  private PressurePredicateAdjustment pressurePredicateAdjustment = new PressurePredicateAdjustment();

  @Test
  public void The_Pressure_Generated_Should_Be_Within_The_Range() {
    double max = 1022;
    double min = 1010;
    WeatherPredicate weatherPredicate = new WeatherPredicate(Location.Sydney);
    WeatherConditionCriteria weatherConditionCriteria = new WeatherConditionCriteria(Location.Sydney, new Position(-12.34, 89.34));
    pressurePredicateAdjustment.adjust(weatherPredicate, weatherConditionCriteria);
    assertTrue("The generated pressure should be greater or equal to lowest in range", weatherPredicate.getPressure() >= min);
    assertTrue("The generated pressure should be lesser or equal to the highest in range", weatherPredicate.getPressure() <= max);
  }
}
