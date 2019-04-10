package com.commbank.weather.domain;

public class Weather {

  private WeatherCondition weatherCondition;
  private WeatherPredicate weatherPredicate;

  public Weather(
      WeatherCondition weatherCondition,
      WeatherPredicate weatherPredicate) {
    this.weatherCondition = weatherCondition;
    this.weatherPredicate = weatherPredicate;
  }

  public WeatherCondition getWeatherCondition() {
    return weatherCondition;
  }

  public WeatherPredicate getWeatherPredicate() {
    return weatherPredicate;
  }
}
