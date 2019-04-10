package com.commbank.weather.report;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WeatherReportRunner {

  private static Logger logger = LoggerFactory.getLogger(WeatherReportRunner.class);

  public static void main(String args[]) {
    logger.debug("Generating weather simulation ... ");
    WeatherReportGenerator weatherReportGenerator = new FlatFormatReportGenerator();
    List<String> reports = weatherReportGenerator.generateReport();
    logger.debug("No of weather reports generated ... ", reports.size());
    for (String report : reports) {
      logger.info(report);
    }
  }
}
