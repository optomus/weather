package com.commbank.weather.service.simulator.adjustment;

import static com.commbank.weather.service.util.WeatherUtil.randomNumber;

import com.commbank.weather.domain.Location;
import com.commbank.weather.domain.WeatherPredicate;
import com.commbank.weather.service.domain.WeatherConditionCriteria;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class DateTimePredicateAdjustment implements WeatherPredicateAdjustment {

  private final Map<Location, ZoneId> timeZones = new HashMap<>();
  private final static int MIN_DAYS = 1;
  private final static int MAX_DAYS = 30;

  public DateTimePredicateAdjustment() {
    this.timeZones.put(Location.Sydney, ZoneId.of("Australia/Sydney"));
    this.timeZones.put(Location.Melbourne, ZoneId.of("Australia/Melbourne"));
    this.timeZones.put(Location.Adelaide, ZoneId.of("Australia/Adelaide"));
    this.timeZones.put(Location.Darwin, ZoneId.of("Australia/Darwin"));
    this.timeZones.put(Location.Perth, ZoneId.of("Australia/Perth"));
    this.timeZones.put(Location.Brisbane, ZoneId.of("Australia/Brisbane"));
    this.timeZones.put(Location.Hobart, ZoneId.of("Australia/Hobart"));
    this.timeZones.put(Location.Auckland, ZoneId.of("Pacific/Auckland"));
    this.timeZones.put(Location.QueensTown, ZoneId.of("Pacific/Apia"));
    this.timeZones.put(Location.Christchurch, ZoneId.of("Pacific/Apia"));
    this.timeZones.put(Location.LosAngelos, ZoneId.of("America/Los_Angeles"));
    this.timeZones.put(Location.NewYork, ZoneId.of("America/New_York"));

  }

  public void adjust(WeatherPredicate weatherPredicate, WeatherConditionCriteria weatherConditionCriteria) {
    final ZonedDateTime zonedDateTime =
        ZonedDateTime.now(timeZones.get(weatherConditionCriteria.getLocation()));
    weatherPredicate.setLocalDateTime(adjustDate(zonedDateTime));
  }


  private ZonedDateTime adjustDate(final ZonedDateTime dateTime) {
    double days = randomNumber(MAX_DAYS, MIN_DAYS);
    if (Math.random() % 2 == 0) {
      return dateTime.plusDays((int) days);
    } else {
      return dateTime.minusDays((int) days);
    }
  }
}
