package java8.datetimeapi.code;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DateAndTimeFormatting {
    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);
        System.out.println(localDateTime
                .format(DateTimeFormatter.ISO_DATE_TIME));//default datetime format
        String formattedDate = localDateTime.format(DateTimeFormatter
                .ofPattern("yyyy/MM/dd'T'hh:mm:ss"));
        System.out.println(formattedDate);

        String formattedDate1 = localDateTime
                .format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        System.out.println(formattedDate1);

    }
}
