package com.commbank.weather.service.simulator;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import com.commbank.weather.service.SimpleWeatherService;
import com.commbank.weather.service.WeatherService;
import com.commbank.weather.service.domain.WeatherConditionCriteria;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WeatherServiceMockTest {

  @Mock
  private WeatherSimulator weatherSimulator;

  @Test
  public void Given_Weather_Reports_Generated_Then_The_Simulator_Service_Should_Be_Invoked_12_Times() {
    WeatherService weatherService = new SimpleWeatherService();
    Whitebox.setInternalState(weatherService, "weatherSimulator", weatherSimulator);
    weatherService.getWeatherReports();
    verify(weatherSimulator, times(12)).simulateWeather(any(WeatherConditionCriteria.class));
  }
}
