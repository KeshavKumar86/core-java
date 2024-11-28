package java8.stream.questions.collectorsmapping.code;

import java8.stream.questions.questionpractice3.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
Example 1: Extracting and Collecting a Single Field
 */
public class Example1 {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "Engineering", 70000),
                new Employee("Charlie", "HR", 60000)
        );

        List<String> employeeNames = employees.stream().collect(Collectors.mapping(
                (Employee e) -> e.getName(),
                Collectors.toList()
        ));

        System.out.println("Employees Names: " + employeeNames);
    }
}
