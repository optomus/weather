package com.commbank.weather.api;

import static com.commbank.weather.api.WeatherTransformer.transformToAPIRepresentation;

import com.commbank.weather.service.SimpleWeatherService;
import com.commbank.weather.service.WeatherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This controller will present the weather report as a visual re-presentation.
 */
@Controller
public class DashboardController {

  private WeatherService weatherService;

  public DashboardController() {
    this.weatherService = new SimpleWeatherService();
  }

  @GetMapping("/dashboard")
  public String dashboard(Model model) {
    model
        .addAttribute("weathers", transformToAPIRepresentation(weatherService.getWeatherReports()));
    return "dashboard";
  }
}
