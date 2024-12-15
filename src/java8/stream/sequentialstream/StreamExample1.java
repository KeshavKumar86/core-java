package java8.stream.sequentialstream;

import java.util.ArrayList;
import java.util.List;

public class StreamExample1 {
    public static void main(String[] args) {
        List<Double> salaryList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            double v = Math.random() * 10_000;
            salaryList.add(v);
        }
        //you have to count total number of salary greater than 5000 using traditional loops
        int count = 0;
        for (Double element : salaryList) {
            if (element > 5000) {
                count++;
            }
        }
        System.out.println("Total Number of Salary>5000: " + count);

        //Now count using java 8 Stream
        long result;
        result = salaryList.stream().filter((Double element) -> element > 5000).count();
        System.out.println("Total Number of Salary>5000 using java Stream: " + result);
    }
}
/*
In Java, Streams are part of the java.util.stream package introduced in Java 8. They provide a
functional-style way to process sequences of elements, such as collections or arrays, with
operations like filtering, mapping, and reducing.

Key Features of Streams
Declarative Style: Allows writing concise and readable code.
Lazy Execution: Operations are not executed until a terminal operation is invoked.
Parallel Processing: Streams can leverage multicore architectures.
Non-modifying: Streams do not modify the source; instead, they return a new stream or result.
Types of Streams
Sequential Streams: Process elements one at a time.
Parallel Streams: Divide the elements into substreams and process them concurrently.

Common Stream Operations:

Intermediate Operations:
Transform the stream but don’t terminate it.
Examples: filter(), map(), sorted(), distinct(), limit(), etc.

Terminal Operations:
Produce a result or a side-effect and terminate the stream.
Examples: collect(), forEach(), reduce(), count(), etc.

Short-circuiting Operations:
Stop processing as soon as a condition is met.
Examples: findFirst(), findAny(), anyMatch(), allMatch(), noneMatch(), etc.

Code Examples
Example 1: Filtering a List

import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        names.stream()
            .filter(name -> name.startsWith("A"))
            .forEach(System.out::println); // Output: Alice
    }
}
Example 2: Mapping and Collecting

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> squares = numbers.stream()
            .map(num -> num * num)
            .collect(Collectors.toList());

        System.out.println(squares); // Output: [1, 4, 9, 16, 25]
    }
}
Example 3: Reducing a Stream

import java.util.Arrays;
import java.util.List;

public class StreamReduceExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        int sum = numbers.stream()
            .reduce(0, Integer::sum);

        System.out.println(sum); // Output: 15
    }
}
Example 4: Using Parallel Streams

import java.util.stream.IntStream;

public class ParallelStreamExample {
    public static void main(String[] args) {
        IntStream.range(1, 10).parallel()
            .forEach(num -> System.out.println(Thread.currentThread().getName() + " processing " + num));
    }
}

Key Notes
Streams are not data structures. They are wrappers for data sources (e.g., collections, arrays).
A stream can only be operated upon once. Reusing it will throw an IllegalStateException.
Use parallel streams cautiously, as they may not always improve performance.

 */