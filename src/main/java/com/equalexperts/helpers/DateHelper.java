package com.equalexperts.helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateHelper {

  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

  public static String getCheckInDate() {
    return LocalDateTime.now().plusDays(1L).format(DateHelper.DATE_FORMAT);
  }

  public static String getCheckOutDate() {
    return LocalDateTime.now().plusDays(7L).format(DateHelper.DATE_FORMAT);
  }
}
