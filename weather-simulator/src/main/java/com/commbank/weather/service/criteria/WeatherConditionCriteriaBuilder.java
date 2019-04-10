package com.commbank.weather.service.criteria;

import com.commbank.weather.domain.Location;
import com.commbank.weather.domain.Position;
import com.commbank.weather.service.domain.WeatherConditionCriteria;
import java.util.ArrayList;
import java.util.List;

public final class WeatherConditionCriteriaBuilder {

  private List<WeatherConditionCriteria> weatherConditionCriteria = new ArrayList<WeatherConditionCriteria>();

  private WeatherConditionCriteriaBuilder() {
  }

  public WeatherConditionCriteriaBuilder addLosAngelos() {
    weatherConditionCriteria
        .add(new WeatherConditionCriteria(Location.LosAngelos, new Position(34.05, -118.24)));
    return this;
  }

  public WeatherConditionCriteriaBuilder addNewYork() {
    weatherConditionCriteria
        .add(new WeatherConditionCriteria(Location.NewYork, new Position(40.73, -73.93)));
    return this;
  }

  public WeatherConditionCriteriaBuilder addAuckland() {
    weatherConditionCriteria
        .add(new WeatherConditionCriteria(Location.Auckland, new Position(-36.84, 174.76)));
    return this;
  }

  public WeatherConditionCriteriaBuilder addChristchurch() {
    weatherConditionCriteria
        .add(new WeatherConditionCriteria(Location.Christchurch, new Position(-43.53, 172.63)));
    return this;
  }

  public WeatherConditionCriteriaBuilder addQueensTown() {
    weatherConditionCriteria
        .add(new WeatherConditionCriteria(Location.QueensTown, new Position(-45.03, 168.66)));
    return this;
  }

  public WeatherConditionCriteriaBuilder addBrisbane() {
    weatherConditionCriteria
        .add(new WeatherConditionCriteria(Location.Brisbane, new Position(-27.47, 153.02)));
    return this;
  }

  public WeatherConditionCriteriaBuilder addSydney() {
    weatherConditionCriteria
        .add(new WeatherConditionCriteria(Location.Sydney, new Position(-33.86, 151.21)));
    return this;
  }

  public WeatherConditionCriteriaBuilder addMelbourne() {
    weatherConditionCriteria
        .add(new WeatherConditionCriteria(Location.Melbourne, new Position(-37.83, 144.98)));
    return this;
  }

  public WeatherConditionCriteriaBuilder addAdelaide() {
    weatherConditionCriteria
        .add(new WeatherConditionCriteria(Location.Adelaide, new Position(-34.92, 138.62)));
    return this;
  }

  public WeatherConditionCriteriaBuilder addDarwin() {
    weatherConditionCriteria
        .add(new WeatherConditionCriteria(Location.Darwin, new Position(-12.46, 130.84)));
    return this;
  }

  public WeatherConditionCriteriaBuilder addPerth() {
    weatherConditionCriteria
        .add(new WeatherConditionCriteria(Location.Perth, new Position(-31.95, 115.85)));
    return this;
  }

  public WeatherConditionCriteriaBuilder addHobart() {
    weatherConditionCriteria
        .add(new WeatherConditionCriteria(Location.Hobart, new Position(-42.88, 147.32)));
    return this;
  }

  public List<WeatherConditionCriteria> collectWeatherConditionCriteria() {
    return this.weatherConditionCriteria;
  }

  public static WeatherConditionCriteriaBuilder build() {
    return new WeatherConditionCriteriaBuilder();
  }

}
