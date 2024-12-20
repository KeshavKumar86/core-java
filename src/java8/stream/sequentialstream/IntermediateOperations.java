package java8.stream.sequentialstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {

        //operation 1: filter(Predicate<T> predicate) used to filter the elements
        Stream<String> filterNameStream = Stream.of
                ("Keshav", "Datta", "Tejaswini", "Payal", "Pradeep");
        //System.out.println("Before Filter: " + filterNameStream.toList());
        Stream<String> filterResultStream = filterNameStream.filter((String name) -> name.length() > 5);
        System.out.println("Filter Result: " + filterResultStream.toList());

        //operation 2: map(Function<T,R> mapper) used to transform each element
        Stream<String> mapNameStream = Stream.of
                ("Keshav", "Datta", "Tejaswini", "Payal", "Pradeep");
        //System.out.println("Before Map: " + mapNameStream);
        Stream<String> mapResultStream = mapNameStream.map((String name) -> name.toUpperCase());
        System.out.println("Map Result: " + mapResultStream.toList());

        //operation 3: flatMap(Function<T,Stream<R>> mapper) used to flatten the list
        List<List<String>> sentenceList = Arrays.asList(Arrays.asList("I", "LOVE", "JAVA"),
                Arrays.asList("CONCEPTS", "ARE", "CLEAR"), Arrays.asList("ITS", "VERY", "EASY"));
        System.out.println("Before FlatMap: " + sentenceList);
        Stream<String> flatMapResultStream = sentenceList.stream()
                .flatMap((List<String> list) -> list.stream());
        System.out.println("FlatMap Result: " + flatMapResultStream.toList());
        Stream<String> flatMapResultStream2 = sentenceList
                .stream().flatMap((List<String> list) ->
                        list.stream().map((String value) -> value.toLowerCase()));
        System.out.println("FlatMap Result2: " + flatMapResultStream2.toList());

        //operation 4: distinct() used to remove duplicates
        Integer[] numbers = {2, 3, 4, 2, 5, 7, 6, 5, 3, 8, 9, 1, 54, 7};
        Stream<Integer> numberStream = Arrays.stream(numbers);
        Stream<Integer> distinctResultStream = numberStream.distinct();
        System.out.println("Distinct Result: " + distinctResultStream.toList());

        //operation 5: sorted() used to sort the elements
        Integer[] unsortedNumbers = {6, 7, 5, 2, 4, 3, 8, 9, 6, 5, 4, 10, 15, 12};
        Stream<Integer> unsortedStream = Arrays.stream(unsortedNumbers);
        Stream<Integer> sortedResultStream = unsortedStream.sorted();
        System.out.println("Increasing Order Sorted Result : " + sortedResultStream.toList());
        Integer[] unsortedNumbers2 = {6, 7, 5, 2, 4, 3, 8, 9, 6, 5, 4, 10, 15, 12};
        Stream<Integer> unsortedStream2 = Arrays.stream(unsortedNumbers2);
        Stream<Integer> sortedResultStream2 = unsortedStream2
                .sorted((Integer val1, Integer val2) -> val2 - val1);// sort in decreasing order
        System.out.println("Decreasing Order Sorted Result : " + sortedResultStream2.toList());

        //operation 6: peek(Consumer<T> action) Helps you to see the intermediate result of the
        //stream which is getting processed
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.print("Filtered Result: ");
        Stream<Integer> peekResultStream = list.stream()
                .filter((Integer number) -> number > 4)
                .peek((Integer filteredNumber) -> System.out.print(filteredNumber + ", "))
                .map((Integer num) -> num * -1);
        System.out.println("Peek Result: " + peekResultStream.toList());

        //operation 7: limit(long maxSize) used to truncated to be no longer than maxSize in length.
        //  return first n elements in the encounter order
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> limitResultStream = numberList.stream().limit(5);
        System.out.println("Limit Result: " + limitResultStream.toList());

        //operation 8: skip(long n) used to skip the first n elements of the stream
        //Returns a stream consisting of the remaining elements of this stream after discarding the
        // first n elements of the stream. If this stream contains fewer than n elements then an empty
        // stream will be returned.
        List<Integer> skipList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Stream<Integer> skipResultStream = skipList.stream().skip(4);
        System.out.println("Skip Result: " + skipResultStream.toList());

        //operation 9: mapToInt(ToIntFunction<T> mapper) helps to works with primitive int data types
        //Returns an IntStream
        List<String> numbers1 = Arrays.asList("2", "1", "4", "7");
        IntStream intStream = numbers1.stream()
                .mapToInt((String number) -> Integer.parseInt(number));
        int[] numberArray = intStream.toArray();
        System.out.println("MapToInt Result: " + Arrays.toString(numberArray));
        int[] numbersArray = {2, 3, 4, 5, 6, 78, 9};
        int[] filteredArray = Arrays.stream(numbersArray)
                .filter((int number) -> number > 4).toArray();
        System.out.println("MapToInt Result2: " + Arrays.toString(filteredArray));

        //operation 10: mapToLong(toLongFunction<T>mapper) helps to work with primitive long data type
        String[] stringArray = {"1", "2", "3", "4"};
        Stream<String> stringStream = Arrays.stream(stringArray);
        LongStream longStream = stringStream.mapToLong((String s) -> Long.parseLong(s));
        long[] longArray = longStream.toArray();
        System.out.println("MapToLong Result: " + Arrays.toString(longArray));

        //operation 11: mapToDouble(toDoubleFunction<T>mapper) helps to work with
        // primitive double data type
        String[] array = {"2.4", "2.5", "8.5", "9.7"};
        Stream<String> stringStream1 = Arrays.stream(array);
        DoubleStream doubleStream = stringStream1.mapToDouble((String s) -> Double.parseDouble(s));
        double[] doubleArray = doubleStream.toArray();
        System.out.println("MapToDouble Result: " + Arrays.toString(doubleArray));

        //operation 12: takeWhile(Predicate<? super T> predicate) (Java 9+) helps to
        // Take elements from the stream as long as they match the predicate. Stops as soon as an
        // element fails the predicate test.
        Integer[] array1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Stream<Integer> integerStream1 = Arrays.stream(array1);
        Stream<Integer> takeWhileResultStream = integerStream1
                .takeWhile((Integer element) -> element < 10);
        System.out.println("TakeWhile Result: " + takeWhileResultStream.toList());

        //operation 13: dropWhile(Predicate<? super T> predicate) (Java 9+) Discards elements as
        // long as they match the predicate and then takes the rest of the stream.
        Integer[] integerArray2 = {4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Stream<Integer> integerStream2 = Arrays.stream(integerArray2);
        Stream<Integer> dropWhileStreamResult = integerStream2
                .dropWhile((Integer element) -> element < 10);
        System.out.println("DropWhile Result: " + dropWhileStreamResult.toList());


    }
}
/*
filter(Predicate<? super T> predicate)
Filters elements based on a condition. It only includes elements that match the given predicate.
Example: stream.filter(x -> x > 10)

map(Function<? super T, ? extends R> mapper)
Transforms each element by applying a function and returns a stream of the transformed elements.
Example: stream.map(String::toUpperCase)

flatMap(Function<? super T, ? extends Stream<? extends R>> mapper)
Transforms each element into a stream, then flattens all the streams into a single stream.
Example: stream.flatMap(Collection::stream)

distinct()
Removes duplicate elements from the stream, based on the equals() method.
Example: stream.distinct()

sorted()
Sorts elements in their natural order or based on a custom comparator if provided.
Example: stream.sorted()

sorted(Comparator<? super T> comparator)
Sorts elements based on a given comparator.
Example: stream.sorted(Comparator.reverseOrder())

limit(long maxSize)
Limits the number of elements in the stream to a given number.
Example: stream.limit(5)

skip(long n)
Skips the first n elements of the stream and processes the remaining.
Example: stream.skip(3)

peek(Consumer<? super T> action)
Allows performing an action on each element in the stream without changing the stream.
Useful for debugging.
Example: stream.peek(System.out::println)

takeWhile(Predicate<? super T> predicate) (Java 9+)
Takes elements from the stream as long as they match the predicate. Stops as soon as an element
fails the predicate test.
Example: stream.takeWhile(x -> x < 10)

dropWhile(Predicate<? super T> predicate) (Java 9+)
Discards elements as long as they match the predicate and then takes the rest of the stream.
Example: stream.dropWhile(x -> x < 10)
 */
