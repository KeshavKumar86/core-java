package java8.stream.questions.groupingbyquestion;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class GroupingByQuestion {
    public static void main(String[] args) {

        //Question1: Basic Grouping
        //Groups items into a Map where the keys are based on a property of the items,
        // and the values are lists of items.
        List<String> names = Arrays.asList("Alice", "Bob", "Anna", "David", "Alex");
        Map<Character, List<String>> groupedByFirstLetter = names.stream()
                .collect(Collectors.groupingBy((String s) -> s.charAt(0)));
        System.out.println(groupedByFirstLetter);

        //Question2: Sum of Salaries by Department
        //Group employees by department and calculate the total salary for each department
        // using Streams. Return a Map<String, Double>.
        //Example of Collectors.groupingBy(classifier, downstreamCollector)
        //2. Grouping with Downstream Collector
        //Groups items and performs an additional operation on the grouped values, like summing
        // numbers or counting items.
        List<Employee1> employees1 = Arrays.asList(
                new Employee1("Alice", "HR", 50000),
                new Employee1("Bob", "Engineering", 70000),
                new Employee1("Charlie", "HR", 60000),
                new Employee1("Diana", "Engineering", 75000),
                new Employee1("Edward", "Marketing", 80000)
        );
        Map<String, Double> collect = employees1.stream().collect(Collectors.groupingBy(employee1 -> employee1.department,
                Collectors.summingDouble(employee1 -> employee1.salary)
        ));
        //The forEach method takes a BiConsumer when applied to a Map, meaning it expects two
        // arguments: the key and the value.
        collect.forEach((String department, Double salary)
                -> System.out.println(department + " " + salary));

        //3. Custom Map Implementation
        //By default, Collectors.groupingBy uses a HashMap. You can provide a custom map,
        // such as TreeMap, for sorted results.
        List<String> names1 = Arrays.asList("Alice", "Anna", "Alex", "Bob", "David");
        Map<Character, List<String>> groupedByFirstLetter1 = names1.stream()
                .collect(Collectors.groupingBy(
                        (String s) -> s.charAt(0), // classifier
                        TreeMap::new, // custom map implementation
                        Collectors.toList() //DownStream Collector
                ));
        System.out.println(groupedByFirstLetter1);

        //Question4: You are given a list of words. Group the words by their length into a TreeMap,
        // so the groups are sorted by word length in ascending order. Additionally, for each group,
        // collect the words into a list.
        List<String> words = Arrays.asList(
                "stream", "grouping", "Java", "custom", "TreeMap", "API", "code", "fun"
        );
        TreeMap<Integer, List<String>> collect1 = words.stream()
                .collect(Collectors.groupingBy(
                        (String s) -> s.length(),
                        TreeMap::new,
                        Collectors.toList()
                ));
        System.out.println(collect1);

    }
}
/*
Syntax: Collectors.groupingBy(classifier)
Collectors.groupingBy(classifier, downstreamCollector)
Collectors.groupingBy(classifier, mapFactory, downstreamCollector)
Explanation of Parameters
classifier: A function that determines the key for grouping. For example, an employee's department.
downstreamCollector (optional): A further collector that processes grouped items. Examples include
Collectors.counting(), Collectors.summingDouble(), etc.
mapFactory (optional): A supplier to create a custom Map implementation instead of the default HashMap.
 */
