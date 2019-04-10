package com.commbank.weather.service.infrastructure;

import static com.commbank.weather.service.util.WeatherUtil.randomNumber;

public class HighResolutionMapElevationResolver implements ElevationResolver {

  private final static int MIN_ELEVATION = 250;
  private final static int MAX_ELEVATION = 5000;

  /**
   * The method will resolve the elevation from a high res map using longitude and latitude.
   */
  public double resolveElevation(double latitude, double longitude) {
    return randomNumber(MAX_ELEVATION, MIN_ELEVATION);
  }
}
