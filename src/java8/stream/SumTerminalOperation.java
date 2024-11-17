package java8.stream;

import java.util.Arrays;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class SumTerminalOperation {
    public static void main(String[] args) {

        Integer[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        IntStream intStream = Arrays.stream(array).mapToInt((Integer e) -> e);
        System.out.println("Sum Result: " + intStream.sum());

        Double[] doubleArray = {1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7, 8.8, 9.9};
        DoubleStream doubleStream = Arrays.stream(doubleArray)
                .mapToDouble((Double element) -> element);
        System.out.println("Long Sum Result: " + doubleStream.sum());
    }
}
/*
Yes, sum() is a terminal operation in Java Streams.
Explanation
The sum() method is a terminal operation available for specialized numeric streams like:
IntStream
LongStream
DoubleStream

It calculates the sum of all elements in the stream and returns the result.

Example: Using sum() with IntStream

import java.util.stream.IntStream;

public class SumExample {
    public static void main(String[] args) {
        int sum = IntStream.range(1, 6) // Stream of 1, 2, 3, 4, 5
                           .sum();     // Terminal operation to sum elements

        System.out.println("Sum: " + sum); // Output: Sum: 15
    }
}

When to Use sum()
Use it when dealing with numeric streams for simplicity and better readability.
For non-numeric streams (e.g., Stream<Integer>), use reduce() instead.

Example: Sum with Stream<Integer> using reduce()
If you have a generic stream of numbers:

import java.util.Arrays;
import java.util.List;

public class SumWithReduce {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers.stream()
                         .reduce(0, Integer::sum); // Accumulate the sum

        System.out.println("Sum: " + sum); // Output: Sum: 15
    }
}
Key Differences: sum() vs. reduce()
Feature	sum()	reduce()
Usage	Works only with numeric streams (IntStream, etc.) -> Works with any Stream<T>
Readability	Shorter and simpler -> More flexible but verbose
Performance	Optimized for primitive streams -> Depends on implementation
In summary, sum() is a terminal operation specialized for primitive numeric streams,
making it an efficient and concise choice when applicable.
 */