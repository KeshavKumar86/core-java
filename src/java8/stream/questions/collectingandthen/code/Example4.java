package java8.stream.questions.collectingandthen.code;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Example 4: Transforming a List into a String
 */
public class Example4 {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        String joinedString = names.stream().collect(Collectors.collectingAndThen(
                Collectors.toList(),
                list -> String.join(",", list)
        ));

        System.out.println("Result: " + joinedString);
    }
}
