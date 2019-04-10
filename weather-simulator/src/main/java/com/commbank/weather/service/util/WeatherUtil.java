package com.commbank.weather.service.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public final class WeatherUtil {

  private static NumberFormat TWO_DECIMAL_FORMATTER = new DecimalFormat("#0.00");

  public static double randomNumber(double max, double min) {
    return (Math.random() * ((max - min) + 1)) + min;
  }

  public static String formatToTwoDecimalPoints(double value) {
    return TWO_DECIMAL_FORMATTER.format(value);
  }

  public static double toTwoDecimalPoints(double value) {
    return Double.parseDouble(formatToTwoDecimalPoints(value));
  }
}
