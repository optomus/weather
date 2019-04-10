package com.commbank.weather.service.simulator;

import static org.junit.Assert.assertTrue;

import com.commbank.weather.domain.Location;
import com.commbank.weather.domain.Weather;
import com.commbank.weather.service.SimpleWeatherService;
import com.commbank.weather.service.WeatherService;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class WeatherServiceIntegrationTest {

  @Test
  public void Given_Weather_Reports_Generated_Then_The_Service_Should_Provide_Condition_For_12_Locations() {
    WeatherService weatherService = new SimpleWeatherService();
    List<Weather> weathers = weatherService.getWeatherReports();
    Location[] allLocations = Location.values();

    for (Weather weather : weathers) {
      assertTrue("All locations should be included in the weather report",
          Arrays.asList(allLocations).contains(weather.getWeatherPredicate().getLocation()));
    }
  }
}
