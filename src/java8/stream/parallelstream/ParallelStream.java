package java8.stream.parallelstream;

import java.util.Arrays;
import java.util.List;

public class ParallelStream {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(11, 22, 33, 44, 55, 66, 77, 88, 99, 110);
        //sequential Processing
        long sequentialProcessingStartTime = System.currentTimeMillis();
        numbers.stream()
                .map((Integer element) -> element * element)
                .forEach((Integer element) -> System.out.println(element));
        System.out.println("Sequential Processing time taken: " +
                (System.currentTimeMillis() - sequentialProcessingStartTime) + " millisecond");

        long parallelProcessingStartTime = System.currentTimeMillis();
        numbers.parallelStream()
                .map((Integer element) -> element * element)
                .forEach((Integer element) -> System.out.println(element));
        System.out.println("Parallel Processing time taken: " +
                (System.currentTimeMillis() - parallelProcessingStartTime) + " millisecond");
    }
}
/*
what is parallel stream?
Helps to perform operations on stream concurrently, taking advantage of multicore
CPU.
ParallelStream() method is used instead of regular stream() method.
Internally it does:
-TaskSplitting: it used spliterator function to split the data into
multiple chunks
-Task Submission and parallel processing: Uses fork-join pool technique

In Java, Parallel Streams enable processing elements in a multithreaded manner, leveraging the
available CPU cores for performance improvements.
They are part of the java.util.stream package introduced in Java 8.

Key Features of Parallel Streams
Automatic Parallelism: Divides the workload into sub-tasks and processes them in multiple threads.
Fork/Join Framework: Internally uses the Fork/Join framework to manage and execute tasks.
Efficient for Large Data: Especially beneficial when working with large collections or CPU-intensive
tasks.

How to Create a Parallel Stream
You can convert a sequential stream to a parallel stream using the parallel() method, or directly
create a parallel stream using parallelStream():

import java.util.Arrays;
import java.util.List;

public class ParallelStreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve");

        // Using parallelStream()
        names.parallelStream()
             .forEach(name -> System.out.println(Thread.currentThread().getName() + " - " + name));

        // Converting sequential stream to parallel
        names.stream()
             .parallel()
             .forEach(name -> System.out.println(Thread.currentThread().getName() + " - " + name));
    }
}

you can perform same operations with parallel stream, whichever operations you can perform with
stream.


Performance Considerations
When to Use Parallel Streams:
Large datasets.
CPU-intensive tasks (e.g., data transformations or computations).
Tasks with no interdependencies (no shared state or order dependency).

When to Avoid Parallel Streams:
Small datasets (parallelism overhead can negate benefits).
I/O-bound operations (e.g., file or network access).
Operations requiring strict order (e.g., forEachOrdered()).
Combining with Ordered Streams:

By default, parallel streams do not guarantee the order of processing.
Use forEachOrdered() for maintaining order:
java
Copy code
IntStream.range(1, 10)
         .parallel()
         .forEachOrdered(System.out::println); // Maintains order

Threading Behavior
Parallel streams use the common ForkJoinPool, which has a default parallelism level equal to the
number of CPU cores. You can customize this by setting the java.util.concurrent.ForkJoinPool
.common.parallelism system property.

Example:
java
Copy code
System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "4");

Caveats
Thread Safety: Ensure that shared resources are properly synchronized to avoid race conditions.
Debugging Complexity: Debugging multithreaded streams can be harder compared to sequential streams.
Overhead: For small datasets or simple operations, the overhead of parallelization can
outweigh the benefits.

Parallel streams are a powerful tool for improving performance in the right scenarios.
However, careful consideration is needed to avoid potential pitfalls, particularly with
thread safety and overhead.
 */