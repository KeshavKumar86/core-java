package java8.stream.questions.collectorsmapping.code;

import java8.stream.questions.questionpractice3.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/*
Example 2: Extracting and Collecting into a Set
 */
public class Example2 {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "HR", 60000),
                new Employee("Charlie", "Engineering", 70000)
        );

        Set<String> departments = employees.stream().collect(Collectors.mapping(
                (Employee e) -> e.getDepartment(),
                Collectors.toSet()
        ));

        System.out.println("Distinct Departments: " + departments);
    }
}
