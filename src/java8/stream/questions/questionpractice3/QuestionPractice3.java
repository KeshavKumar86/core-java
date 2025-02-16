package java8.stream.questions.questionpractice3;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java8.stream.questions.questionpractice2.QuestionPractice2.isPalindrome;

public class QuestionPractice3 {
    public static void main(String[] args) {

        /*1. Most Frequent Character in Strings
        Input:
        List<String> words = Arrays.asList("stream", "programming", "Java", "functional", "collector");

        Task:
        Find the most frequent character (case-sensitive) across all the strings in the list.
        If there's a tie, return any one of the most frequent characters.*/
        List<String> words = Arrays.asList("stream", "programming", "Java", "functional", "collector");
        Map<Character, Long> collect6 = words.stream().flatMapToInt((String s) -> s.chars())
                .mapToObj((int c) -> (char) c)
                .collect(Collectors.groupingBy(
                        (Character c) -> c,
                        Collectors.counting()
                ));
        char mostFrequent = collect6.entrySet().stream()
                .max((Map.Entry<Character, Long> entry1, Map.Entry<Character, Long> entry2) ->
                        (int) (entry2.getValue() - entry1.getValue())
                ).map((Map.Entry<Character, Long> entry) -> entry.getKey())
                .orElseThrow(() -> new RuntimeException("No Character Found"));
        System.out.println("Question1 Result: " + mostFrequent);

        /*2. Partition Numbers by Odd and Even
        Input:
        List<Integer> numbers = Arrays.asList(12, 7, 5, 64, 23, 77, 45, 90, 11);

        Task:
        Partition the list of numbers into two groups: odd and even. Use Streams to return
        a Map<Boolean, List<Integer>> where:
        Key true represents odd numbers.
                Key false represents even numbers.*/
        List<Integer> numbers = Arrays.asList(12, 7, 5, 64, 23, 77, 45, 90, 11);
        Map<Boolean, List<Integer>> collect = numbers.stream()
                .collect(Collectors.partitioningBy((Integer i) -> i % 2 != 0));
        System.out.println("Question2 Result: " + collect);

        /*3. Group by First Letter and Sort Groups by Key
        Input:
        List<String> names = Arrays.asList("Alice", "Bob", "Adam", "Brian", "Cathy",
         "Charles", "David");

        Task:
        Group the names by their first letter and ensure the groups are sorted alphabetically by the
        first letter. Use a TreeMap as the custom map implementation.*/
        List<String> names = Arrays.asList("Alice", "Bob", "Adam", "Brian", "Cathy",
                "Charles", "David");
        TreeMap<Character, List<String>> collect1 = names.stream().collect(Collectors.groupingBy(
                (String name) -> name.charAt(0),
                TreeMap::new,
                Collectors.toList()
        ));
        System.out.println("Question3 Result: " + collect1);


        /*4. Second Highest Salary by Department
        Task: Find the second-highest salary in each department and return a Map<String, Double>
        where the key is the department and the value is the second-highest salary.*/
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", "HR", 50000),
                new Employee("Bob", "Engineering", 70000),
                new Employee("Charlie", "HR", 60000),
                new Employee("Diana", "Engineering", 75000),
                new Employee("Edward", "Marketing", 80000),
                new Employee("Fiona", "HR", 55000)
        );
        Map<String, Double> collect5 = employees.stream()
                .collect(Collectors.groupingBy(
                        (Employee e) -> e.department,
                        Collectors.collectingAndThen(
                                Collectors.mapping((Employee e) -> e.salary, Collectors.toList()),
                                list -> list.stream().sorted(Comparator.reverseOrder())
                                        .skip(1)
                                        .findFirst()
                                        .orElse(0.0)

                        )
                ));
        System.out.println("Question4 Result: " + collect5);

        /*5. Concatenate Grouped Strings
        Input:
        List<String> words = Arrays.asList("stream", "grouping", "Java", "code",
         "streaming", "coding");
        Task:
        Group the words by their length, then concatenate all words in each group into a single
        string. Return a Map<Integer, String> where:
        Key: Word length.
        Value: Concatenated string of all words with that length.*/
        List<String> words1 = Arrays.asList("stream", "grouping", "Java", "code",
                "streaming", "coding");
        Map<Integer, String> question5Result = words1.stream().collect(Collectors.groupingBy(
                (String s) -> s.length(),
                Collectors.joining()
        ));
        System.out.println("Question5 Result: " + question5Result);

        /*6. Most Expensive Product in Each Category
        Task:
        Find the most expensive product in each category and return a Map<String, Product> where
        the key is the category, and the value is the most expensive product in that category.*/
        List<Product> products = Arrays.asList(
                new Product("Laptop", "Electronics", 800),
                new Product("Smartphone", "Electronics", 600),
                new Product("Tablet", "Electronics", 500),
                new Product("Shoes", "Fashion", 80),
                new Product("Jacket", "Fashion", 120),
                new Product("Watch", "Accessories", 150)
        );
        Map<String, List<Product>> result = products.stream().collect(Collectors.groupingBy(
                (Product p) -> p.category,
                Collectors.toList()
        ));
        Set<Map.Entry<String, List<Product>>> entrySet = result.entrySet();
        Map<String, Optional<Product>> collect2 = entrySet.stream().collect(Collectors.toMap(
                (Map.Entry<String, List<Product>> entry) -> entry.getKey(),
                (Map.Entry<String, List<Product>> entry1) -> entry1.getValue().stream()
                        .max((Product p1, Product p2) -> (int) (p1.price - p2.price))
        ));
        System.out.println("Question6 Result: " + collect2);

        //Second Solution
        Map<String, Product> collect4 = products.stream().collect(Collectors.groupingBy(
                (Product p) -> p.category,
                Collectors.collectingAndThen(
                        Collectors.maxBy((Product p1, Product p2) -> (int) (p1.price - p2.price)),
                        (Optional<Product> p) -> p.get()
                )

        ));
        System.out.println("Question6 Result2: " + collect4);

        /*7. Group Words by Palindrome Status
        Input:
        List<String> words = Arrays.asList("level", "world", "radar", "Java", "civic", "coding", "madam");
        Task:
        Partition the words into palindromes and non-palindromes. Use Streams to return a
        Map<Boolean, List<String>> where:
        Key true: Palindromes.
        Key false: Non-palindromes.*/
        List<String> words2 = Arrays.asList("level", "world", "radar", "Java", "civic",
                "coding", "madam");
        Map<Boolean, List<String>> question7Result = words2.stream().collect(Collectors.partitioningBy(
                (String s) -> isPalindrome(s)
        ));
        System.out.println("Question7 Result: " + question7Result);

        //Question8: 8. Merge and Count Duplicates
        //Input:
        //List<String> list1 = Arrays.asList("apple", "banana", "cherry", "apple", "date");
        //List<String> list2 = Arrays.asList("banana", "date", "elderberry", "fig", "cherry");
        //
        //Task:
        //Merge the two lists into a single list and count the occurrences of each word.
        // Return a Map<String, Long> where the key is the word, and the value is its count.
        List<String> list1 = Arrays.asList("apple", "banana", "cherry", "apple", "date");
        List<String> list2 = Arrays.asList("banana", "date", "elderberry", "fig", "cherry");
        Map<String, Long> question8Result = Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.groupingBy(
                        (String s) -> s,
                        Collectors.counting()
                ));
        System.out.println("Question8 Result: " + question8Result);

        /*9. Average Salary by Department
        Input:
        Use the same Employee class and employees list as defined in Question 4.
        Task:
        Calculate the average salary for each department and return a Map<String, Double> where:
        Key: Department name.
        Value: Average salary of employees in that department.*/
        Map<String, Double> question9Result = employees.stream().collect(Collectors.groupingBy(
                (Employee employee) -> employee.department,
                Collectors.averagingDouble((Employee employee) -> employee.salary)
        ));
        System.out.println("Question9 Result: " + question9Result);

        /*10. Find Top N Frequent Words
        Input:
        List<String> words = Arrays.asList("apple", "banana", "cherry", "apple", "date",
        "banana", "apple", "cherry", "banana", "date", "banana");
        Task:
        Find the top 2 most frequent words in the list along with their frequencies. Return a
        Map<String, Long> where:
        Key: The word.
        Value: Frequency of that word.*/
        List<String> words3 = Arrays.asList("apple", "banana", "cherry", "apple", "date",
                "banana", "apple", "cherry", "banana", "date", "banana");
        Map<String, Long> map1 = words3.stream().collect(Collectors.groupingBy(
                (String s) -> s,
                Collectors.counting()
        ));
        Set<Map.Entry<String, Long>> set = map1.entrySet();
        Map<String, Long> collect3 = set.stream()
                .sorted((Map.Entry<String, Long> entry1, Map.Entry<String, Long> entry2) ->
                        Math.toIntExact(entry2.getValue() - entry1.getValue()))
                .limit(2)
                .collect(Collectors.toMap(
                        (Map.Entry<String, Long> entry) -> entry.getKey(),
                        (Map.Entry<String, Long> entry) -> entry.getValue()
                ));
        System.out.println(collect3);
    }
}
