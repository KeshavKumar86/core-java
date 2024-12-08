package java8.datetimeapi.code;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateExample {
    public static void main(String[] args) {
        /*
        Obtains the current date from the system clock in the default time-zone
        The LocalDate represents a date in ISO format (yyyy-MM-dd) without time.
         */
        LocalDate localDate = LocalDate.now();
        System.out.println("Current Date: " + localDate);

        /*
        The LocalDate provides various utility methods to obtain a variety of information.
        Let’s have a quick peek at some of these API methods.
         */
        System.out.println("Current Day: " + localDate.getDayOfMonth());
        System.out.println("Day of current week: " + localDate.getDayOfWeek());
        System.out.println("Current Month: " + localDate.getMonth());
        System.out.println("Current Year: " + localDate.getYear());
        LocalDate tomorrowDate = localDate.plusDays(1);
        System.out.println("Tomorrow Date: " + tomorrowDate);
        LocalDate nextMonthDate = localDate.plusMonths(1);
        System.out.println("Next Month Date: " + nextMonthDate);
        System.out.println("Next Month: " + localDate.plusMonths(1).getMonth());
        System.out.println("Next Year: " + localDate.plusYears(1).getYear());

        boolean isBefore = LocalDate.parse("2024-12-25")
                .isBefore(LocalDate.parse("2025-01-01"));
        System.out.println(isBefore);

        /*
        we can get the LocalDate representing a specific day, month and year by using the of method
         or the parse method.
         */
        LocalDate date = LocalDate.of(1999, 6, 8);
        System.out.println("Any Day Date: " + date);

        LocalDate date1 = LocalDate.parse("2015/02/20",
                DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        System.out.println("Any Day Date: " + date1);


    }
}
