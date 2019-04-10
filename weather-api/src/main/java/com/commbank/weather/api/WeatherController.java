package com.commbank.weather.api;

import static com.commbank.weather.api.WeatherTransformer.transformToAPIRepresentation;

import com.commbank.weather.api.dto.ApiWeather;
import com.commbank.weather.service.SimpleWeatherService;
import com.commbank.weather.service.WeatherService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class WeatherController {

  private WeatherService weatherService;

  public WeatherController() {
    this.weatherService = new SimpleWeatherService();
  }

  @GetMapping("/weather/report")
  public List<ApiWeather> getWeatherReport() {
    return transformToAPIRepresentation(weatherService.getWeatherReports());
  }

}
