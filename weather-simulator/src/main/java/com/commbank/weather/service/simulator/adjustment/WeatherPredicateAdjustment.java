package com.commbank.weather.service.simulator.adjustment;

import com.commbank.weather.domain.WeatherPredicate;
import com.commbank.weather.service.domain.WeatherConditionCriteria;

public interface WeatherPredicateAdjustment {

  void adjust(WeatherPredicate weatherPredicate, WeatherConditionCriteria weatherConditionCriteria);

}
