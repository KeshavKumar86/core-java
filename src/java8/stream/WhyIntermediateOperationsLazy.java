package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class WhyIntermediateOperationsLazy {
    public static void main(String[] args) {
        //here we will see the example to prove the point that intermediate operation are lazy
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> integerStream = list.stream()
                .filter((Integer element) -> element > 4)
                .peek((Integer filteredElement) -> System.out.println(filteredElement));
        System.out.println(integerStream.toList());
    }
}
/*
In this code, we're demonstrating the laziness of intermediate operations in Java streams.
Here’s what happens and why intermediate operations like filter and peek are considered lazy:

Explanation

Stream<Integer> integerStream = list.stream()
    .filter((Integer element) -> element > 4)
    .peek((Integer filteredElement) -> System.out.println(filteredElement));
Here, a stream pipeline is created with two intermediate operations:

.filter(element -> element > 4): Filters elements greater than 4.
.peek(System.out::println): Peeks at each element, printing it to the console.
Laziness of Intermediate Operations: Intermediate operations in a stream (such as filter and peek) are
lazy; they do not execute until a terminal operation is applied to the stream.

No Terminal Operation: Because the code lacks a terminal operation, such as toList() or forEach(),
the pipeline is never executed. As a result:

No elements are filtered.
No elements are printed to the console.
output:

To Test Laziness
You can uncomment the line with integerStream.toList() to add a terminal operation:

System.out.println(integerStream.toList());
Expected Output with toList():
If you add toList():

The filter operation will filter elements greater than 4.
The peek operation will print these filtered elements.
The output would then be:

5
6
7
8
9
10
[5, 6, 7, 8, 9, 10]

 */