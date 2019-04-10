package com.commbank.weather.domain;

public class Position {

  private double longitude;
  private double latitude;
  private double elevation;

  public Position(double latitude, double longitude) {
    this.longitude = longitude;
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  public double getElevation() {
    return elevation;
  }

  public void setElevation(double elevation) {
    this.elevation = elevation;
  }
}
