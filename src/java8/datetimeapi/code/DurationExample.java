package java8.datetimeapi.code;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DurationExample {
    public static void main(String[] args) {

        /*
        Similar to Period, the Duration class is used to deal with Time.
         */
        Duration duration = Duration.between(LocalTime.now(), LocalTime.MAX);
        System.out.println("Time remaining in today: " +
                duration.get(ChronoUnit.SECONDS) + " Seconds");
    }
}
