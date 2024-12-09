package java8.datetimeapi.code;

import java.time.*;

public class ZonedDateTimeExample {
    public static void main(String[] args) {

        System.out.println(ZoneId.getAvailableZoneIds());
        /*
        A time-zone ID, such as Europe/Paris.
        A ZoneId is used to identify the rules used to convert between an Instant and a LocalDateTime.

        List<String> asia = ZoneId.getAvailableZoneIds().stream().filter((String zoneId) -> {
            return zoneId.contains("Asia");
        }).toList();
        System.out.println("Asia Time Zones: " + asia);*/

        ZonedDateTime currentZonedDateTime = ZonedDateTime.now();
        System.out.println("Current ZonedDateTime: " + currentZonedDateTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.of("Asia/Dhaka");
        /*
        The LocalDateTime can be converted to a specific zone:
         */
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDateTime, zoneId);
        System.out.println(zonedDateTime);

        System.out.println(ZonedDateTime.now(ZoneId.of("Europe/Paris")));
        System.out.println(ZonedDateTime.now(ZoneId.of("Australia/Sydney")));

        ZonedDateTime zonedDateTime1 = ZonedDateTime
                .parse("2024-12-09T14:14:11.757004+11:00[Australia/Sydney]");
        System.out.println(zonedDateTime1);

        /*
        Another way to work with time zone is by using OffsetDateTime. The OffsetDateTime is an
        immutable representation of a date-time with an offset. This class stores all date and time
        fields, to a precision of nanoseconds, as well as the offset from UTC/Greenwich.
         */
        ZoneOffset zoneOffset = ZoneOffset.of("+02:00");
        OffsetDateTime offsetDateTime = OffsetDateTime.of(localDateTime, zoneOffset);
        System.out.println(offsetDateTime);
    }
}
