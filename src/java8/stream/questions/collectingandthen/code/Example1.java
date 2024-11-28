package java8.stream.questions.collectingandthen.code;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
Example 1: Making the Result Immutable
 */
public class Example1 {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        List<String> immutableNames = names.stream().collect(Collectors.collectingAndThen(
                Collectors.toList(),
                Collections::unmodifiableList
        ));
        System.out.println("Result: " + immutableNames);

        // Attempting to modify will throw an UnsupportedOperationException
        immutableNames.add("Diana"); //throw Exception
    }
}
