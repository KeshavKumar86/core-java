package java8.datetimeapi.code;

import java.time.LocalTime;

public class LocalTimeExample {
    public static void main(String[] args) {

        /*
        Obtains the current time from the system clock in the default time-zone
         */
        LocalTime currentTime = LocalTime.now();
        System.out.println("Current Time: " + currentTime);

        /*
        Obtains an instance of LocalTime from an hour, minute and second
         */
        LocalTime time = LocalTime.of(12, 30, 45);
        System.out.println("Time: " + time);

        /*
        Obtains an instance of LocalTime from a text string such as 10:15
         */
        LocalTime localTime = LocalTime.parse("16:30:57");
        System.out.println("LocalTime: " + localTime);
        System.out.println(localTime.minusHours(6));
        System.out.println(localTime.getHour());
        System.out.println(localTime.getMinute());
        System.out.println(localTime.getSecond());
        System.out.println(localTime.getNano());
        System.out.println(localTime.toSecondOfDay());
        System.out.println(localTime.isBefore(LocalTime.of(17, 1, 1)));
        System.out.println(LocalTime.MAX);
        System.out.println(LocalTime.MIN);
        System.out.println(LocalTime.MIDNIGHT);


        /*
        Key Points to Remember
        Patterns for DateTimeFormatter:
        HH: Hour (00-23, 24-hour format).
        hh: Hour (01-12, 12-hour format).
        mm: Minutes (00-59).
        ss: Seconds (00-59).
        a: AM/PM marker (if using hh for 12-hour format).
        Order Consistency: Ensure the order of components in your input string matches the order
        specified in the pattern.
        Validation: The parse method will throw a DateTimeParseException if the input string or the
        pattern is invalid. Always validate your inputs if they come from external sources.
         */


    }
}
