package com.commbank.weather.service.domain;

import com.commbank.weather.domain.Location;
import com.commbank.weather.domain.Position;

public class WeatherConditionCriteria {

  private Location location;
  private Position position;

  public WeatherConditionCriteria(Location location, Position position) {
    this.location = location;
    this.position = position;
  }

  public Location getLocation() {
    return location;
  }

  public Position getPosition() {
    return position;
  }
}
