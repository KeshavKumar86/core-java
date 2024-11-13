package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
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


    }
}
