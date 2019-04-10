package com.commbank.weather.report;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import com.commbank.weather.domain.Location;
import com.commbank.weather.domain.Position;
import com.commbank.weather.domain.Weather;
import com.commbank.weather.domain.WeatherCondition;
import com.commbank.weather.domain.WeatherPredicate;
import com.commbank.weather.service.WeatherService;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WeatherReportGeneratorTest {

  @Mock
  private WeatherService weatherService;
  private WeatherReportGenerator weatherReportGenerator = new FlatFormatReportGenerator();

  @Test
  public void Given_Weather_Report_Generated_It_Should_Be_Represented_In_Certain_Way() {
    List<Weather> weathers = new ArrayList<>();
    WeatherPredicate weatherPredicate = new WeatherPredicate(Location.Sydney);
    Position position = new Position(-12.55, 156.98);
    position.setElevation(257);
    weatherPredicate.setPosition(position);
    weatherPredicate.setHumidity(75);
    weatherPredicate.setPressure(34);
    weatherPredicate.setTemperature(28);
    weatherPredicate.setLocalDateTime(
        ZonedDateTime.of(2019, 04, 11, 2, 11, 45, 0, ZoneId.systemDefault())
    );

    Weather weather = new Weather(WeatherCondition.Sunny, weatherPredicate);
    weathers.add(weather);

    when(weatherService.getWeatherReports()).thenReturn(weathers);
    Whitebox.setInternalState(weatherReportGenerator, "weatherService", weatherService);
    List<String> reports = weatherReportGenerator.generateReport();
    assertEquals("No of reports should ne 1",  1, reports.size());
    assertEquals("Report format did ot match", "Sydney|-12.55,156.98,257.00|2019-04-10T16:11:45Z|Sunny|28.00|34.00|75.00", reports.stream().findFirst().get());
  }
}
