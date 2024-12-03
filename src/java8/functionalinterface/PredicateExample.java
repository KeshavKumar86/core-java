package java8.functionalinterface;

import java8.stream.questions.findnthhighestsalary.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {
    public static void main(String[] args) {

        /*
        Predicate is a Functional Interface inside filter intermediate operation of stream API.
        Evaluates this predicate on the given argument.
        Params:
        t – the input argument
        Returns:
        true if the input argument matches the predicate, otherwise false
         */
        Predicate<Integer> predicate = (Integer value) -> value > 40_000;
        int salary = 35_000;
        System.out.println("Salary greater than 40000: " + predicate.test(salary));

        Predicate<String> stringPredicate = new Predicate<>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("K");
            }
        };
        String name = "Keshav";
        System.out.println("Name starts with \"K\": " + stringPredicate.test(name));

        Predicate<Student> studentPredicate = (Student s) -> s.getMarks() > 80;
        List<Student> studentList = Arrays.asList(
                new Student(1, 78, "Ritesh"),
                new Student(2, 88, "Ankur"),
                new Student(3, 80, "Vikas"),
                new Student(4, 82, "Lalit")
        );
        for (Student s : studentList) {
            if (studentPredicate.test(s)) {
                System.out.println("Student With marks greater than 80: " + s.getName());
            }
        }

        Predicate<String> startWithK = (String s) -> s.startsWith("K");
        Predicate<String> endWithV = (String s) -> s.toLowerCase().endsWith("v");

        Predicate<String> and = startWithK.and(endWithV);
        System.out.println("Name start with 'K' and end with 'v': " + and.test("Keshav"));

        Predicate<String> or = startWithK.or(endWithV);
        System.out.println("Name start with 'k' or end with 'v': " + or.test("Kunal"));

        Predicate<String> negate = startWithK.negate();
        System.out.println("Name not starting with 'K': " + negate.test("Lalit"));

        Predicate<String> not = Predicate.not(endWithV);
        System.out.println("Name not ending with V: " + not.test("Ritesh"));


    }
}
