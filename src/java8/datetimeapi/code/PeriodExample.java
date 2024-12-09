package java8.datetimeapi.code;

import java.time.LocalDate;
import java.time.Period;

public class PeriodExample {
    public static void main(String[] args) {

        /*
        Obtains a Period representing a number of years, months and days.
        This creates an instance based on years, months and days.
         */
        Period period = Period.of(1,6,-1);

        LocalDate localDate = LocalDate.now();
        LocalDate modifiedDate = localDate.plus(period);
        System.out.println(localDate);
        System.out.println(modifiedDate);

        System.out.println(LocalDate.now().plus(Period.ofMonths(6)));
        System.out.println(LocalDate.now().plus(Period.of(0,6,-1)));

        LocalDate dhoniBirthDate = LocalDate.of(2025,7,7);
        Period period1 = Period.between(localDate,dhoniBirthDate);
        System.out.println("Dhoni birthday is after " + period1.getYears() + " Years " +
                period1.getMonths() + " Months " + period1.getDays() + " Days");



    }
}
/*
The Period class is widely used to modify values of given a date or to obtain the difference between
two dates:
 */