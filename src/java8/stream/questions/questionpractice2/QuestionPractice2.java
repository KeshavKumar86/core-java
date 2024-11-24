package java8.stream.questions.questionpractice2;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class QuestionPractice2 {
    public static void main(String[] args) {

        //Question1: Filter Odd Numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> oddNumbers = numbers.stream()
                .filter((Integer i) -> i % 2 != 0)
                .toList();
        System.out.println("Original Numbers: " + numbers);
        System.out.println("Odd Numbers: " + oddNumbers);

        //Question2: Find Words Starting with 'A'
        List<String> words = Arrays.asList("Apple", "Banana", "Avocado", "Cherry", "Apricot",
                "Date", "Almond");
        List<String> question2Result = words.stream()
                .filter((String s) -> s.startsWith("A"))
                .toList();
        System.out.println("Original words: " + words);
        System.out.println("Starts with A words: " + question2Result);

        //Question3: Square and Sum Numbers
        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers1.stream()
                .map((Integer i) -> i * i)
                .mapToInt((Integer i) -> i)
                .sum();
        System.out.println("Original numbers: " + numbers1);
        System.out.println("Sum of squares of numbers: " + sum);

        //Question4: Count Strings Longer Than 5
        List<String> names = Arrays.asList("Michael", "Sarah", "John", "Elizabeth", "Sophia", "Max");
        long count = names.stream().filter((String s) -> s.length() > 5).count();
        System.out.println("Original names: " + names);
        System.out.println("Count names Longer Than 5: " + count);

        //Question5: Sort and Collect
        List<String> names1 = Arrays.asList("Anna", "Tom", "Harry", "Eve", "Charlie", "Bob");
        List<String> sortedNames = names1.stream()
                .sorted((String s1, String s2) -> s1.compareTo(s2))
                .toList();
        System.out.println("Original Names: " + names1);
        System.out.println("Sorted Names: " + sortedNames);

        //Question6: Group by Length
        List<String> words1 = Arrays.asList("apple", "bat", "ant", "dog", "elephant", "cat", "frog");
        Map<Integer, List<String>> result = words1.stream()
                .collect(Collectors.groupingBy((String s) -> s.length()));
        System.out.println("Original Words: " + words1);
        System.out.println("Group by Length: " + result);

        //Question7: Distinct Even Numbers
        List<Integer> numbers2 = Arrays.asList(2, 4, 6, 8, 10, 4, 6, 12, 2);
        List<Integer> question7Result = numbers2.stream()
                .filter((Integer i) -> i % 2 == 0).distinct().toList();
        System.out.println("Original numbers: " + numbers2);
        System.out.println("Result numbers: " + question7Result);

        //Question8: Concatenate all strings in the list into a single
        // string with spaces in between using Streams.
        List<String> phrases = Arrays.asList("Java", "is", "fun", "to", "learn");
        String concatenatedString = phrases.stream().collect(Collectors.joining(" "));
        System.out.println("Original phrases: " + phrases);
        System.out.println("Concatenated String: " + concatenatedString);

        //Question9: Find Employees in Specific Age Range
        //Find all employees whose age is between 25 and 35 (inclusive) and collect their names
        // into a list.
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", 25, 50000),
                new Employee("Bob", 35, 70000),
                new Employee("Charlie", 30, 60000),
                new Employee("Diana", 22, 40000),
                new Employee("Edward", 40, 80000)
        );
        List<Employee> filteredEmployees = employees.stream()
                .filter((Employee employee) -> employee.age >= 25 && employee.age <= 35)
                .toList();
        System.out.println("Original Employees: " + employees);
        System.out.println("Filtered Employees: " + filteredEmployees);

        //Question10: Check if List Contains Palindromes
        List<String> words2 = Arrays.asList("radar", "level", "world", "java", "civic", "hello");
        List<String> palindromes = words2.stream()
                .filter((String word) -> isPalindrome(word)).toList();
        System.out.println("Original Words: " + words2);
        System.out.println("Palindrome Words: " + palindromes);
    }

    private static boolean isPalindrome(String word) {
        int low = 0, high = word.length() - 1;
        while (low < high) {
            if (word.charAt(low++) != word.charAt(high--))
                return false;
        }
        return true;
    }
}
