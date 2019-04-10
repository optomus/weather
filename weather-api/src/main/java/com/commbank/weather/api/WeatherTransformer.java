package com.commbank.weather.api;

import static com.commbank.weather.service.util.WeatherUtil.toTwoDecimalPoints;

import com.commbank.weather.api.dto.ApiWeather;
import com.commbank.weather.domain.Position;
import com.commbank.weather.domain.Weather;
import com.commbank.weather.domain.WeatherPredicate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class WeatherTransformer {

  public static List<ApiWeather> transformToAPIRepresentation(List<Weather> weathers) {
    final List<ApiWeather> apiWeathers = new ArrayList<>(weathers.size());
    for (Weather weather : weathers) {
      final WeatherPredicate weatherPredicate = weather.getWeatherPredicate();
      final Position position = new Position(
          toTwoDecimalPoints(weatherPredicate.getPosition().getLatitude()),
          toTwoDecimalPoints(weatherPredicate.getPosition().getLongitude()));
      position.setElevation(toTwoDecimalPoints(weatherPredicate.getPosition().getElevation()));

      final ApiWeather apiWeather = new ApiWeather();
      apiWeather.setLocation(weatherPredicate.getLocation().name());
      apiWeather.setPosition(position);
      apiWeather
          .setDateTime(weatherPredicate.getLocalDateTime().format(DateTimeFormatter.ISO_INSTANT));
      apiWeather.setCondition(weather.getWeatherCondition().name());
      apiWeather.setTemperature(toTwoDecimalPoints(weatherPredicate.getTemperature()));
      apiWeather.setPressure(toTwoDecimalPoints(weatherPredicate.getPressure()));
      apiWeather.setHumidity(toTwoDecimalPoints(weatherPredicate.getHumidity()));

      apiWeathers.add(apiWeather);
    }

    return apiWeathers;
  }

}
