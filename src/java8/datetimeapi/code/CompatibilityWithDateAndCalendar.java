package java8.datetimeapi.code;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.Date;

public class CompatibilityWithDateAndCalendar {
    public static void main(String[] args) {

        /*
        Java 8 has added the toInstant() method, which helps to convert existing Date and Calendar
        instance to new Date and Time API:
         */

        System.out.println(LocalDateTime
                .ofInstant(new Date().toInstant(), ZoneId.systemDefault()));

        /*
        The LocalDateTime can be constructed from epoch seconds
         */
        System.out.println(LocalDateTime
                .ofEpochSecond(1465817690, 0, ZoneOffset.UTC));
    }
}
