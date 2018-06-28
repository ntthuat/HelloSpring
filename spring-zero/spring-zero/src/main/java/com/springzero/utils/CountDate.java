package com.springzero.utils;

import org.joda.time.DateTime;
import org.joda.time.Days;

/**
 * Joda time dependency:
 * <dependency>
 <groupId>joda-time</groupId>
 <artifactId>joda-time</artifactId>
 <version>2.9.9</version>
 </dependency>
 */

public class CountDate {

  private static int count2Date(DateTime date1, DateTime date2){
    int days = Days.daysBetween(date1, date2).getDays();
    return days;
  }

  private static int maximum = 708;

  public static void main(String[] args){
    DateTime date1 = new DateTime("2018-01-21");
    DateTime date2 = new DateTime("2018-02-02");
    System.out.println("reach: " + count2Date(date1, date2));
    System.out.println("remain: " + (maximum-count2Date(date1, date2)));
    System.out.println();

    //
    date2 = new DateTime("2018-05-02");
    System.out.println("reach: " + count2Date(date1, date2));
    System.out.println("remain: " + (maximum-count2Date(date1, date2)));
  }
}
