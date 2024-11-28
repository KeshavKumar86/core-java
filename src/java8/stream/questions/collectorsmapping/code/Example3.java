package java8.stream.questions.collectorsmapping.code;

import java8.stream.questions.questionpractice3.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Example 3: Using mapping in a GroupingBy Collector
Group employees by department and collect their names
 */
public class Example3 {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "Engineering", 70000),
                new Employee("Charlie", "HR", 60000),
                new Employee("Diana", "Engineering", 75000)
        );

        Map<String,List<String>> map = employees.stream().collect(Collectors.groupingBy(
                (Employee e)->e.getDepartment(),
                Collectors.mapping(
                        (Employee e)->e.getName(),
                        Collectors.toList()
                )
        ));
        System.out.println("Result: " + map);

    }
}
