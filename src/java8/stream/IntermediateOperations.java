package java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {

        //operation 1: filter(Predicate<T> predicate) filter the elements
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

        //operation 3: flatMap(Function<T,Stream<R>> mapper)
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


    }
}
