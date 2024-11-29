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
                list -> String.join(" ", list)
        ));

        System.out.println("Result: " + joinedString);
    }
}
/*
Why Didn't We Assign list?
The list variable in the finisher function doesn't need to be explicitly assigned because it is
provided by the collect() operation. collect() passes the result of the downstream collector
(Collectors.toList()) to the finisher function, and the lambda expression automatically takes this
result as input.
 */