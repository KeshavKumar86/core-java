package java8.stream.questions.collectingandthen.code;

import java8.stream.questions.questionpractice3.Employee;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
Example 3: Post-Processing a Grouping Operation
Collect the number of employees in each department and return Map<String,Integer>
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
                        map -> Collections.unmodifiableMap(map) // Make the map immutable
                ));

        System.out.println(deptCount);
    }
}
/*
Key Concept: Collectors.summingInt
Purpose: Collectors.summingInt is a specialized collector used to calculate the sum of integers
derived from stream elements.

public static <T> Collector<T, ?, Integer> summingInt(ToIntFunction<? super T> mapper)
T: The type of elements in the stream.
mapper: A function that maps each element in the stream to an integer.
Result: Returns the total sum of the mapped integer values.

Explanation of Collectors.summingInt(emp -> 1)
emp -> 1: This is a lambda function (a ToIntFunction) that:
Takes an input (an Employee object).
Always returns the integer 1, regardless of the specific Employee.
Usage in Collectors.groupingBy:
When used inside Collectors.groupingBy, this lambda ensures that each Employee contributes 1 to the
sum.
The total sum in each group, therefore, represents the count of employees in that group.
Detailed Execution Flow
Let’s walk through the example with the given list of employees:

List<Employee> employees = Arrays.asList(
    new Employee("Alice", "HR", 50000),
    new Employee("Bob", "Engineering", 70000),
    new Employee("Charlie", "HR", 60000),
    new Employee("Diana", "Engineering", 75000)
);

Map<String, Integer> deptCount = employees.stream()
    .collect(Collectors.collectingAndThen(
        Collectors.groupingBy(emp -> emp.department, Collectors.summingInt(emp -> 1)), // Count employees by department
        Collections::unmodifiableMap
    ));
Stream of Employees: The employees.stream() creates a stream of Employee objects:
[Alice, Bob, Charlie, Diana]

Grouping by Department:
The Collectors.groupingBy(emp -> emp.department, ...) groups employees by their department:
HR → [Alice, Charlie]
Engineering → [Bob, Diana]

Summing with Collectors.summingInt:
For each group (e.g., HR and Engineering), the second argument Collectors.summingInt(emp -> 1) is
applied:
HR:
Alice → 1
Charlie → 1
Total: 1 + 1 = 2 (count of HR employees)
Engineering:
Bob → 1
Diana → 1
Total: 1 + 1 = 2 (count of Engineering employees)

Result of groupingBy: The result of the Collectors.groupingBy step is a mutable Map:
{HR=2, Engineering=2}

Post-Processing with collectingAndThen:
The collectingAndThen makes the map immutable using Collections.unmodifiableMap.

Final Result: The final output is:
{HR=2, Engineering=2}
Why Use emp -> 1?
The lambda emp -> 1 acts as a constant mapper, meaning every Employee contributes exactly 1 to
the sum.
This effectively turns the summing operation into a counting operation for each group.
Alternative for Counting
Instead of using Collectors.summingInt(emp -> 1), you can achieve the same result with
Collectors.counting():

Map<String, Long> deptCount = employees.stream()
    .collect(Collectors.groupingBy(emp -> emp.department, Collectors.counting()));
The result would be similar, but the values would be Long instead of Integer:
{HR=2, Engineering=2}

When to Use summingInt?
Use Collectors.summingInt when:
You want to calculate a sum based on a numeric property of the stream elements.
Example: Summing salaries.
Collectors.summingInt(emp -> emp.salary);
You want to count items indirectly by using a constant value like 1.
For direct counting, Collectors.counting() is often simpler and more expressive.
 */
