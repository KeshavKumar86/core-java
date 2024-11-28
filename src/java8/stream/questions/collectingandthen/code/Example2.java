package java8.stream.questions.collectingandthen.code;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/*
Example 2: Finding the Maximum Length Name
 */
public class Example2 {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        String maxLengthName = names.stream().collect(Collectors.collectingAndThen(
                Collectors.maxBy(
                        (String s1, String s2) -> s1.length() - s2.length()
                ),
                (Optional<String> optional) -> optional.orElse("No Maximum Length name present")
        ));

        System.out.println("Maximum Length Name: " + maxLengthName);

    }
}
