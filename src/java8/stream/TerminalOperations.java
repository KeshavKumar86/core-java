package java8.stream;

import java.util.Arrays;
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
    }
}
/*
Terminal operations are the ones that produces the result. It triggers the processing of the stream.
 */
