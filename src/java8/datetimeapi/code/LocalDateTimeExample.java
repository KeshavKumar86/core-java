package java8.datetimeapi.code;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExample {
    public static void main(String[] args) {

        /*
        Obtains the current date-time from the system clock in the default time-zone.
         */
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("currentDateTime: " + currentDateTime);
        System.out.println(currentDateTime.getDayOfWeek());
        System.out.println(currentDateTime.getDayOfMonth());
        System.out.println(currentDateTime.getDayOfYear());
        System.out.println(currentDateTime.toLocalDate().isLeapYear());

        /*
        Obtains an instance of LocalDateTime from year, month, day, hour, minute and second,
        setting the nanosecond to zero.
         */
        LocalDateTime localDateTime = LocalDateTime
                .of(2024, 12, 8, 8, 59, 25);
        System.out.println("LocalDateTime: " + localDateTime);

        /*
           Obtains an instance of LocalDate from a year, month and day
         */
        LocalDate localDate = LocalDate.of(2024, 12, 8);
        System.out.println(localDate);
        LocalTime localTime = LocalTime.of(9, 2, 45);
        System.out.println(localTime);
        LocalDateTime localDateTime1 = LocalDateTime.of(localDate, localTime);
        System.out.println(localDateTime1);

        /*
        Pattern Components:
        yyyy: Year (e.g., 2024).
        MM: Month (01-12).
        dd: Day of the month (01-31).
        'T': Literal separator between date and time.
        HH: Hour in 24-hour format (00-23).
        mm: Minutes (00-59).
        ss: Seconds (00-59).
         */
        LocalDateTime localDateTime2 = LocalDateTime
                .parse("2024-12-08T08:59:25",
                        DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
        System.out.println(localDateTime2);


    }
}
