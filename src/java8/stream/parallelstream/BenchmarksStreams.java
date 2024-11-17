package java8.stream.parallelstream;

import java.util.stream.LongStream;

public class BenchmarksStreams {
    public static void main(String[] args) {
        long start, end;
        start = System.currentTimeMillis();
        long sum = LongStream.range(1, 1_000_000).sum();
        end = System.currentTimeMillis();
        System.out.println("Sequential Stream Time: " + (end - start));
        System.out.println("Sum: " + sum);

        start = System.currentTimeMillis();
        sum = LongStream.range(1, 1_000_000).parallel().sum();
        end = System.currentTimeMillis();
        System.out.println("Sum: " + sum);
        System.out.println("Parallel Stream Time: " + (end - start));

    }
}
