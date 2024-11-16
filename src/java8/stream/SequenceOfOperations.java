package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SequenceOfOperations {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> integerStream = numbers.stream()
                .filter((Integer element) -> element > 3)
                .peek((Integer element) -> System.out.println("After Filter: " + element))
                .map((Integer element) -> element * -1)
                .peek((Integer element) -> System.out.println("After Negating: " + element))
                .sorted()
                .peek((Integer element) -> System.out.println("After Sorting: " + element));
        List<Integer> filteredResultStream = integerStream.toList();
        System.out.println(filteredResultStream);
    }
}

/*
why lazy processing?
Generally each element processed sequentially and can perform multiple operations, this feature helps
stream to fast process the task.
for example if you need to return any number which is greater than 3, processing will stop at
4 itself.


for sorted() each element should be present in the stream before, but for map, filter, peek it is not
necessary that all elements should be present, they will process the elements one by one why?

Great observation! Let's delve into why sorted() behaves differently from operations like map, filter,
and peek in a stream pipeline.

1. Lazy Processing vs. Eager Processing
Lazy Intermediate Operations (e.g., filter, map, peek): These operations are typically stateless and
can process each element independently as it passes through the pipeline. They don’t need to know
about the entire dataset at once, so they operate one element at a time.
Eager Intermediate Operations (e.g., sorted): This is a stateful operation, which means it requires
knowledge of the entire dataset before it can proceed. Sorting requires all elements to be available
because it must determine the order of each element relative to all others.
2. One-Pass Processing (Stateless Operations)
filter, map, peek: These operations are "stateless," meaning each element can be processed independently, without depending on the state of other elements. For instance:
filter checks if an element passes a condition and immediately moves it forward in the pipeline if
it does.
map transforms each element individually without needing any context about the other elements.
peek simply observes elements as they pass through.
This independence allows the stream pipeline to process elements one-by-one, in a single pass, as
they’re requested.
3. Multi-Pass Processing (Stateful Operations)
sorted: Sorting is "stateful," meaning it needs to see all elements before it can output them in
sorted order. It can’t proceed until it has collected the entire dataset. Once it has all elements,
it sorts them and then lets them pass down the pipeline.
Because of this, the sorted operation forces the pipeline to pause and accumulate all elements up to
that point before continuing.
4. How the Pipeline Executes with sorted()
When a terminal operation is invoked, the stream pipeline begins to pull elements through.
The stream executes the intermediate operations in sequence for each element until it reaches sorted().
 At that point, sorted() holds all elements, sorts them, and then lets them pass to the next operation.
After sorting, operations like peek or map will again operate one-by-one on each element, but only
after the full dataset has been ordered by sorted.
Example:
If we take a look at the sequence below:

java
Copy code
Stream<Integer> integerStream = numbers.stream()
    .filter(element -> element > 3)
    .map(element -> element * -1)
    .sorted()
    .peek(element -> System.out.println("After Sorting: " + element))
    .toList();
Here:

filter and map will process each element one-by-one until sorted is reached.
sorted will accumulate all elements that passed through filter and map, sort them, and only then pass
them one-by-one to the next stage, peek.
Summary
Stateless operations (filter, map, peek) process elements as they come, independently.
Stateful operations (sorted, distinct, limit, etc.) may require the entire dataset to operate
correctly, which is why they disrupt the one-by-one processing of elements.


Here is a breakdown of stateless and stateful intermediate operations in Java Streams:

Stateless Intermediate Operations
Stateless operations process each element independently without requiring the entire dataset or
maintaining any state between elements.

filter(Predicate<T>)

Selects elements that match a condition.
Example: .filter(x -> x > 5)
map(Function<T, R>)

Transforms each element into another value.
Example: .map(x -> x * 2)
flatMap(Function<T, Stream<R>>)

Flattens nested structures into a single stream.
Example: .flatMap(list -> list.stream())
peek(Consumer<T>)

Applies a side-effect operation to each element (e.g., logging).
Example: .peek(System.out::println)
distinct() (special case if applied to unordered streams)

Removes duplicate elements but doesn't require sorting if the stream is unordered.
Stateful Intermediate Operations
Stateful operations require knowledge of the entire dataset or need to maintain state to produce
the result. They cannot process each element independently.

sorted()

Sorts elements in natural order or using a custom comparator.
Example: .sorted(Comparator.naturalOrder())
distinct() (when applied to ordered streams)

Removes duplicates while maintaining order. Requires remembering seen elements.
limit(long maxSize)

Truncates the stream to a specified size. Requires counting elements.
skip(long n)

Skips the first n elements and processes the rest. Requires counting elements.
reduce(BinaryOperator<T>) (when used as part of a combined operation)

Accumulates elements into a single result, depending on all prior data.
 */
