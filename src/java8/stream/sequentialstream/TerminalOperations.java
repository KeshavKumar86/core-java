package java8.stream.sequentialstream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class TerminalOperations {
    public static void main(String[] args) {

        //operation1: forEach(Consumer<T> action) perform action on each element of the stream.
        //Do not return any value
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        integerList.stream()
                .filter((Integer element) -> element > 3)
                .forEach((Integer element) -> System.out.println(element));

        //operation2: toArray() collect the element of the stream into an array
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Object[] toArrayResult = numbers.stream()
                .filter((Integer element) -> element > 4)
                .toArray();
        System.out.println("ToArray() Result1: " + Arrays.toString(toArrayResult));
        List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Integer[] integers = numberList.stream()
                .filter((Integer element) -> element > 6)
                .toArray((int size) -> new Integer[size]);
        System.out.println("ToArray() Result2: " + Arrays.toString(integers));


        //operation3: reduce(BinaryOperator<T> accumulator) does reduction on the elements of the
        //stream. perform associate aggregation function
        List<Integer> integerList1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14);
        Optional<Integer> reducedValue = integerList1.stream()
                .reduce((Integer val1, Integer val2) -> val1 + val2);
        System.out.println("Reduced Result: " + reducedValue.get());

        //operation4: collect(Collector<T,A,R> collector) can be used to collect the elements of the
        //stream into a list
        List<Integer> integerList2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> collectResultList = integerList2.stream()
                .map((Integer element) -> element * 3)
                .collect(Collectors.toList());
        System.out.println("Collect Result: " + collectResultList);

        //operation5: min() find the minimum from the stream based on the comparator provided
        List<Integer> integerList3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Optional<Integer> minResult = integerList3.stream()
                .min((Integer val1, Integer val2) -> val1 - val2);
        System.out.println("Min Result: " + minResult.get());

        //operation6: max() find the maximum from the stream based on the comparator provided
        List<Integer> maxInteger = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Optional<Integer> maxIntegerResult = maxInteger.stream()
                .max((Integer val1, Integer val2) -> val1 - val2);
        System.out.println("Max Result: " + maxIntegerResult.get());

        //operation7: count() count the number of elements in the stream
        List<Integer> countIntegers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        long countIntegersResult = countIntegers.stream().count();
        System.out.println("Count Result: " + countIntegersResult);

        //operation8: anyMatch(Predicate<T> predicate) Checks if any value in the stream
        //match the given predicate and returns the boolean
        List<String> anyMatchIntegers = Arrays
                .asList("Keshav", "Datta", "Tejaswini", "Payal", "Pradeep");
        boolean nameSizeGreaterThan5 = anyMatchIntegers.stream()
                .anyMatch((String s) -> s.length() > 5);
        System.out.println("AnyMatch Result: " + nameSizeGreaterThan5);

        //operation9: allMatch(Predicate<T> predicate) Checks if All value in the stream
        //match the given predicate and returns the boolean
        List<String> allMatchIntegers = Arrays
                .asList("Keshav", "Datta", "Tejaswini", "Payal", "Pradeep");
        boolean allNameSizeGreaterThan5 = allMatchIntegers.stream()
                .allMatch((String s) -> s.length() > 5);
        System.out.println("AllMatch Result: " + allNameSizeGreaterThan5);

        //operation10: noneMatch(Predicate<T> predicate) Checks if no value in the stream
        //match the given predicate and returns the boolean
        List<String> noneMatchIntegers = Arrays
                .asList("Keshav", "Datta", "Tejaswini", "Payal", "Pradeep");
        boolean noneNameSizeGreaterThan5 = noneMatchIntegers.stream()
                .noneMatch((String s) -> s.length() > 5);
        System.out.println("NoneMatch Result: " + noneNameSizeGreaterThan5);

        //operation11: findFirst() finds the first element of the stream
        List<Integer> findFirstIntegers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Optional<Integer> findFirstResult = findFirstIntegers.stream()
                .filter((Integer element) -> element > 7)
                .findFirst();
        findFirstResult.ifPresent(integer -> System.out.println("FindFirst Result: " + integer));

        //operation12: findAny() finds any random element of the stream
        List<Integer> findAnyInteger = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Optional<Integer> findAnyResult = findAnyInteger.stream().findAny();
        System.out.println("FindAnyResult: " + findAnyResult.get());

        //operation 13: iterator() returns the iterator
        List<String> stringList = Arrays.asList("A", "B", "C", "D", "E");
        Iterator<String> iterator = stringList.stream().iterator();
        while (iterator.hasNext()) {
            System.out.println("Iterator Result: " + iterator.next());
        }
    }
}
/*
Terminal operations are the ones that produces the result. It triggers the processing of the stream.

Here’s a list of the most frequently used terminal operations in Java Streams and their purposes:

1. forEach()
Purpose: Performs an action for each element in the stream.
Returns: void.
Example:
java
Copy code
List<String> names = List.of("Alice", "Bob", "Charlie");
names.stream().forEach(System.out::println);

2. collect()
Purpose: Collects elements of the stream into a collection or other data
structures (e.g., List, Set, Map).
Returns: Result of the collection process.
Example:
java
Copy code
List<String> names = List.of("Alice", "Bob", "Charlie");
List<String> filteredNames = names.stream()
    .filter(name -> name.startsWith("A"))
    .collect(Collectors.toList());

3. reduce()
Purpose: Reduces the elements in the stream to a single value using an associative accumulator.
Returns: The reduced value.
Example:
java
Copy code
List<Integer> numbers = List.of(1, 2, 3, 4, 5);
int sum = numbers.stream().reduce(0, Integer::sum);

4. toArray()
Purpose: Converts the elements in the stream into an array.
Returns: An array of elements.
Example:
java
Copy code
String[] namesArray = List.of("Alice", "Bob", "Charlie").stream()
    .toArray(String[]::new);

5. count()
Purpose: Counts the number of elements in the stream.
Returns: long (the count of elements).
Example:
java
Copy code
long count = List.of("Alice", "Bob", "Charlie").stream()
    .filter(name -> name.startsWith("A"))
    .count();

6. findFirst()
Purpose: Returns the first element of the stream, if available.
Returns: An Optional containing the first element.
Example:
java
Copy code
Optional<String> firstName = List.of("Alice", "Bob", "Charlie").stream()
    .findFirst();

7. findAny()
Purpose: Returns any element from the stream, useful in parallel streams.
Returns: An Optional containing an element.
Example:
java
Copy code
Optional<String> anyName = List.of("Alice", "Bob", "Charlie").stream()
    .findAny();

8. anyMatch()
Purpose: Checks if any element matches a given predicate.
Returns: boolean.
Example:
java
Copy code
boolean hasBob = List.of("Alice", "Bob", "Charlie").stream()
    .anyMatch(name -> name.equals("Bob"));

9. allMatch()
Purpose: Checks if all elements match a given predicate.
Returns: boolean.
Example:
java
Copy code
boolean allStartWithA = List.of("Alice", "Andy", "Anna").stream()
    .allMatch(name -> name.startsWith("A"));

10. noneMatch()
Purpose: Checks if no elements match a given predicate.
Returns: boolean.
Example:
java
Copy code
boolean noneStartWithZ = List.of("Alice", "Bob", "Charlie").stream()
    .noneMatch(name -> name.startsWith("Z"));

11. max()
Purpose: Finds the maximum element based on a comparator.
Returns: An Optional containing the maximum element.
Example:
java
Copy code
Optional<Integer> max = List.of(1, 2, 3, 4, 5).stream()
    .max(Integer::compare);

12. min()
Purpose: Finds the minimum element based on a comparator.
Returns: An Optional containing the minimum element.
Example:
java
Copy code
Optional<Integer> min = List.of(1, 2, 3, 4, 5).stream()
    .min(Integer::compare);

13. iterator()
Purpose: Converts the stream into an Iterator.
Returns: An Iterator object.
Example:
java
Copy code
Iterator<String> iterator = List.of("Alice", "Bob", "Charlie").stream()
    .iterator();
Summary Table
Operation	Purpose	Return Type
forEach()	Perform action on each element	void
collect()	Gather elements into a collection	Collection or result
reduce()	Reduce elements to a single value	Result of reduction
toArray()	Convert elements into an array	Array
count()	Count elements in the stream	long
findFirst()	Get the first element	Optional<T>
findAny()	Get any element	Optional<T>
anyMatch()	Check if any match a condition	boolean
allMatch()	Check if all match a condition	boolean
noneMatch()	Check if none match a condition	boolean
max()	Get the max element	Optional<T>
min()	Get the min element	Optional<T>

 */
