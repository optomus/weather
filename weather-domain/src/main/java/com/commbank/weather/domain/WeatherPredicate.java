package com.commbank.weather.domain;

import java.time.ZonedDateTime;

public class WeatherPredicate {

  private Position position;
  private Location location;
  private double temperature;
  private double pressure;
  private double humidity;
  private ZonedDateTime localDateTime;

  public WeatherPredicate(Location location) {
    this.location = location;
  }

  public double getTemperature() {
    return temperature;
  }

  public void setTemperature(double temperature) {
    this.temperature = temperature;
  }

  public double getPressure() {
    return pressure;
  }

  public void setPressure(double pressure) {
    this.pressure = pressure;
  }

  public double getHumidity() {
    return humidity;
  }

  public void setHumidity(double humidity) {
    this.humidity = humidity;
  }

  public ZonedDateTime getLocalDateTime() {
    return localDateTime;
  }

  public void setLocalDateTime(ZonedDateTime localDateTime) {
    this.localDateTime = localDateTime;
  }

  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public Location getLocation() {
    return location;
  }

}
