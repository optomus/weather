package com.commbank.weather.service.simulator.adjustment;

import static com.commbank.weather.service.util.WeatherUtil.randomNumber;

import com.commbank.weather.domain.Position;
import com.commbank.weather.domain.WeatherPredicate;
import com.commbank.weather.service.domain.WeatherConditionCriteria;
import com.commbank.weather.service.infrastructure.ElevationResolver;
import com.commbank.weather.service.infrastructure.HighResolutionMapElevationResolver;

public class PositionPredicateAdjustment implements WeatherPredicateAdjustment {

  private ElevationResolver elevationResolver;
  private static int MAX_POSITIONS = 5;
  private static int MIN_POSITIONS = 1;

  public PositionPredicateAdjustment() {
    this.elevationResolver = new HighResolutionMapElevationResolver();
  }

  public void adjust(WeatherPredicate weatherPredicate, WeatherConditionCriteria weatherConditionCriteria) {
    final Position position = adjustPosition(weatherConditionCriteria.getPosition());
    adjustElevation(position);
    weatherPredicate.setPosition(position);
  }

  private Position adjustPosition(Position source) {
    final Position position;
    int adjustment = (int) randomNumber(MAX_POSITIONS, MIN_POSITIONS);
    if (Math.random() % 2 != 0) {
      adjustment *= -1;
    }
    position = new Position(source.getLatitude() + adjustment, source.getLongitude() + adjustment);
    return position;
  }

  private void adjustElevation(final Position position) {
    position.setElevation(
        elevationResolver.resolveElevation(position.getLatitude(), position.getLongitude()));
  }
}
