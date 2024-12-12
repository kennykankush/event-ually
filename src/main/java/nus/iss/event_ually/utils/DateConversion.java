package nus.iss.event_ually.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateConversion {

    // Converts epoch in seconds to date in "dd/MM/yyyy" format
    public static String epochToDate(long epoch) {

        // Convert epoch seconds to LocalDateTime
        LocalDateTime dateTime = Instant.ofEpochSecond(epoch)
                                       .atZone(ZoneId.systemDefault())
                                       .toLocalDateTime();
        // Format to "dd/MM/yyyy"
        return dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    // Converts epoch in milliseconds to date in "dd/MM/yyyy" format
    public static String epochMiliToDate(long epochMilli) {

        // Convert epoch milliseconds to LocalDateTime
        LocalDateTime dateTime = Instant.ofEpochMilli(epochMilli)
                                       .atZone(ZoneId.systemDefault())
                                       .toLocalDateTime();
        // Format to "dd/MM/yyyy"
        return dateTime.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    // Converts date in "dd/MM/yyyy" format to epoch in seconds
    public static long dateToEpoch(String date) {

        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Parse the date string to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);

        // Convert LocalDate to epoch seconds
        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().getEpochSecond();
    }

    // Converts date in "dd/MM/yyyy" format to epoch in milliseconds
    public static long dateToEpochMili(String date) {

        // Define the date format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Parse the date string to LocalDate
        LocalDate localDate = LocalDate.parse(date, formatter);

        // Convert LocalDate to epoch milliseconds
        return localDate.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

//  * Common Date Patterns for DateTimeFormatter:
//  *
//  * - "d"          : Day of the month (1-31) without leading zero (e.g., 1, 9, 31).
//  * - "dd"         : Day of the month (01-31) with leading zero (e.g., 01, 09, 31).
//  * - "D"          : Day of the year (1-365/366) (e.g., 1, 100, 365).
//  * - "E"          : Abbreviated day of the week (e.g., Mon, Tue, Wed).
//  * - "EEEE"       : Full day of the week (e.g., Monday, Tuesday, Wednesday).
//  * - "M"          : Month (1-12) without leading zero (e.g., 1, 9, 12).
//  * - "MM"         : Month (01-12) with leading zero (e.g., 01, 09, 12).
//  * - "MMM"        : Abbreviated month name (e.g., Jan, Feb, Mar).
//  * - "MMMM"       : Full month name (e.g., January, February, March).
//  * - "yy"         : Year (two digits, e.g., 22 for 2022).
//  * - "yyyy"       : Year (four digits, e.g., 2022).
//  * - "yyyy/MM/dd" : Year/Month/Day (e.g., 2022/12/25).
//  * - "dd/MM/yyyy" : Day/Month/Year (e.g., 25/12/2022).
//  * - "MM/dd/yyyy" : Month/Day/Year (e.g., 12/25/2022).
//  * - "yyyy-MM-dd" : ISO standard: Year-Month-Day (e.g., 2022-12-25).
//  * - "dd-MM-yyyy" : Day-Month-Year (e.g., 25-12-2022).
//  * - "yyyy-MM-dd'T'HH:mm:ss" : ISO-8601 with time (e.g., 2022-12-25T15:30:00).
//  * - "dd/MM/yyyy HH:mm:ss" : Day/Month/Year Hour:Minute:Second (e.g., 25/12/2022 15:30:00).
//  * - "EEEE, dd MMMM yyyy"  : Full day name, day, full month, year (e.g., Saturday, 25 December 2022).
//  * - "EEE, dd MMM yyyy"    : Abbreviated day, day, abbreviated month, year (e.g., Sat, 25 Dec 2022).
//  * - "yyyy/MM/dd HH:mm:ss" : Year/Month/Day Hour:Minute:Second (e.g., 2022/12/25 15:30:00).

}
    
