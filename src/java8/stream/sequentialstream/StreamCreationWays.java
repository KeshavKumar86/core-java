package java8.stream.sequentialstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamCreationWays {
    public static void main(String[] args) {

        // first way : create stream from collection
        List<Integer> list = Arrays.asList(2, 5, 7, 8, 9, 0);
        Stream<Integer> collectionStream = list.stream();
        System.out.println(collectionStream.collect(Collectors.toList()));

        //second way : create stream from array
        Integer[] array = {2, 5, 7, 89, 9, 6, 4, 7, 8, 8};
        Stream<Integer> arrayStream = Arrays.stream(array);
        System.out.println(arrayStream.collect(Collectors.toList()));

        //third way: From static method
        Stream<Integer> staticStream = Stream.of(1, 2, 3, 4, 5, 6, 7, 8);
        System.out.println(staticStream.collect(Collectors.toList()));

        //forth way: From String Builder(builder pattern example)
        Stream.Builder<Integer> streamBuilder = Stream.builder();
        //add thing using builder
        streamBuilder.add(2);
        streamBuilder.add(3);
        streamBuilder.add(4);
        streamBuilder.add(5);
        streamBuilder.add(6);
        //build the stream
        Stream<Integer> builderStream = streamBuilder.build();
        System.out.println(builderStream.collect(Collectors.toList()));

        //fifth way: From stream iterate
        Stream<Integer> iterateStream = Stream.iterate(1000, (Integer n)->n+4000).limit(7);
        System.out.println(iterateStream.collect(Collectors.toList()));

    }
}
