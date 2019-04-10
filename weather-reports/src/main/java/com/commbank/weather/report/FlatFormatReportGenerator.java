
package com.commbank.weather.report;

import static com.commbank.weather.service.util.WeatherUtil.*;
import com.commbank.weather.domain.Weather;
import com.commbank.weather.domain.WeatherPredicate;
import com.commbank.weather.service.SimpleWeatherService;
import com.commbank.weather.service.WeatherService;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlatFormatReportGenerator implements WeatherReportGenerator {

  private static Logger logger = LoggerFactory.getLogger(FlatFormatReportGenerator.class);

  private static String SEPARATOR = "|";
  private static String COMMA = ",";

  private WeatherService weatherService;

  public FlatFormatReportGenerator() {
    this.weatherService = new SimpleWeatherService();
  }

  @Override
  public List<String> generateReport() {
    List<Weather> weathers = weatherService.getWeatherReports();
    List<String> reports = new ArrayList<>(weathers.size());
    for (Weather weather : weathers) {
      reports.add(createWeatherReport(weather));
    }
    return reports;
  }

  private String createWeatherReport(final Weather weather) {
    final StringBuilder report = new StringBuilder();
    final WeatherPredicate weatherPredicate = weather.getWeatherPredicate();
    report
        .append(weatherPredicate.getLocation())
        .append(SEPARATOR)
        .append(formatToTwoDecimalPoints(weatherPredicate.getPosition().getLatitude()))
        .append(COMMA)
        .append(formatToTwoDecimalPoints(weatherPredicate.getPosition().getLongitude()))
        .append(COMMA)
        .append(formatToTwoDecimalPoints(weatherPredicate.getPosition().getElevation()))
        .append(SEPARATOR)
        .append(weatherPredicate.getLocalDateTime().format(DateTimeFormatter.ISO_INSTANT))
        .append(SEPARATOR)
        .append(weather.getWeatherCondition())
        .append(SEPARATOR)
        .append(formatToTwoDecimalPoints(weatherPredicate.getTemperature()))
        .append(SEPARATOR)
        .append(formatToTwoDecimalPoints(weatherPredicate.getPressure()))
        .append(SEPARATOR)
        .append(formatToTwoDecimalPoints(weatherPredicate.getHumidity()));

    return report.toString();
  }
}
