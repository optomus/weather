package com.commbank.weather.service.infrastructure;

import static com.commbank.weather.service.util.WeatherUtil.randomNumber;

public class HighResolutionMapElevationResolver implements ElevationResolver {

  private final static int MIN_ELEVATION = 250;
  private final static int MAX_ELEVATION = 5000;

  /**
   * The idea behind this implementation is to find the exact elevation for a given GEO location
   * from a HIGH resolution image of a map.
   *
   * For the time being simulating the elevation by randomising within a range.
   *
   */
  public double resolveElevation(double latitude, double longitude) {
    return randomNumber(MAX_ELEVATION, MIN_ELEVATION);
  }
}
