package java8.stream.questions.collectingandthen.code;

import java8.stream.questions.questionpractice3.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Example 3: Post-Processing a Grouping Operation
 */
public class Example3 {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "Engineering", 70000),
                new Employee("Charlie", "HR", 60000),
                new Employee("Diana", "Engineering", 75000)
        );

        Map<String, Integer> deptCount = employees.stream()
                .collect(Collectors.collectingAndThen(
                        Collectors.groupingBy(emp -> emp.getDepartment(), Collectors.summingInt(emp -> 1)), // Count employees by department
                        Collections::unmodifiableMap // Make the map immutable
                ));

        System.out.println(deptCount);

    }
}
