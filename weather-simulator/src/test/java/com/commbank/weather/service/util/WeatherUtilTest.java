package com.commbank.weather.service.util;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 *
 * I am taking minimal effort to showcase test implementation
 */
public class WeatherUtilTest {

  @Test
  public void Given_A_Range_The_Random_Number_Generated_Should_Be_Within_The_Range() {
    double max = 90;
    double min = 5;
    double randomNumber = WeatherUtil.randomNumber(max, min);
    assertTrue("The generated number should be greater or equal to lowest in range", randomNumber >= min);
    assertTrue("The generated number should be lesser or equal to the highest in range", randomNumber <= max);
  }

}
