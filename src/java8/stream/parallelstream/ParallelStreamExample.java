package java8.stream.parallelstream;

import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample {
    public static void main(String[] args) {

        //without parallel stream
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");
        names.stream()
                .forEach((String name) -> System.out.println(Thread.currentThread().getName()
                        + " - " + name));

        System.out.println("Separation Print Statement");

        //with parallel stream
        names.parallelStream()
                .forEach((String name) -> System.out.println(Thread.currentThread().getName()
                        + " - " + name));

        System.out.println("Separation Print Statement");

        //create parallel stream from stream
        names.stream().parallel()
                .forEach((String name) -> System.out.println(Thread.currentThread().getName()
                + " - " + name));
    }
}
