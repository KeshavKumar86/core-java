package java8.stream.sequentialstream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class HowManyTimesStreamCanBeUsed {

    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8,9);
        System.out.println("Original List Size: " + integerList.size());
        Stream<Integer> integerStream = integerList.stream()
                .filter((Integer e) -> e > 4)
                .peek((Integer e) -> System.out.println(e));
        //System.out.println(integerStream);
        System.out.println("Resulted Stream Size: " + integerStream.count());// this is terminal
        // operation, after this stream will be processed
        //after calling the terminal operation we cannot call the intermediate operations because
        //it is no longer a stream anymore
        //integerStream.filter((Integer e)->e>2); // It will give exception like
        // Exception in thread "main" java.lang.IllegalStateException: stream has already been
        // operated upon or closed

    }
}
/*
Here we will see how many times we can use the single stream?
Once terminal operation is used on a stream, it is closed/consumed and cannot be used again for
another terminal operation.
 */