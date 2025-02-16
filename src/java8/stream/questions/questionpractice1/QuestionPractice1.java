package java8.stream.questions.questionpractice1;

import java8.stream.questions.findnthhighestsalary.Student;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class  QuestionPractice1 {
    public static void main(String[] args) {

        //Question1: Given a list of integers, filter out the even numbers & collect the remaining
        //numbers into the new list
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> question1Result = integerList.stream()
                .filter((Integer element) -> element % 2 != 0).toList();
        System.out.println("Question1 Result: " + question1Result);

        //Question2: Given a list of Strings, convert each String to uppercase
        //and collect the result into a new list
        List<String> names = Arrays.asList("Virat", "Rohit", "Hardik", "Rahul", "Risabh");
        List<String> question2Result = names.stream()
                .map((String name) -> name.toUpperCase()).toList();
        System.out.println("Question2 Result: " + question2Result);

        //Question3: Given a list of integers, find the sum of all elements using the reduce method
        List<Integer> integerList1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        Optional<Integer> result = integerList1.stream().reduce((Integer i, Integer j) -> i + j);
        System.out.println("Question3 Result: " + result.get());
        int sum = integerList1.stream().mapToInt((Integer i) -> i).sum();
        System.out.println("Question3 Result: " + sum);

        //Question4: Given a list of integers, filter out the odd numbers, square the remaining
        //numbers & collect them into a new list
        List<Integer> integerList2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> question4Result = integerList2.stream()
                .filter((Integer i) -> i % 2 == 0)
                .map((Integer i) -> i * i).toList();
        System.out.println("Question4 Result: " + question4Result);

        //Question5: Given a list of Strings, group them by their first character.
        List<String> names1 = Arrays.asList
                ("Virat", "Rohit", "Hardik", "Rahul", "Risabh", "Bhuvi", "Bumrah", "Shami", "Shubman");
        Map<Character, List<String>> map = names1.stream()
                .collect(Collectors.groupingBy((String s) -> s.charAt(0)));
        System.out.println("Question5 Result: " + map);

        //Question6: Given a list of Integers, partition the list into 2 list,
        // one containing even numbers and other containing odd numbers
        List<Integer> integerList3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Map<Boolean, List<Integer>> result1 = integerList3.stream()
                .collect(Collectors.partitioningBy((Integer i) -> i % 2 == 0));
        System.out.println("Question6 Result: " + result1);
        List<Integer> list1 = result1.get(true);
        List<Integer> list2 = result1.get(false);
        System.out.println("List1: " + list1 + " List2: " + list2);

        //Question7: Given the list of String find the first String that starts with letter b
        List<String> stringList = Arrays.asList
                ("Virat", "Rohit", "Hardik", "Rahul", "Risabh", "Bhuvi", "Bumrah", "Shami", "Shubman");
        Optional<String> optionalString = stringList.stream()
                .filter((String s) -> s.startsWith("B")).findFirst();
        optionalString.ifPresent(s -> System.out.println("Question7 Result: " + s));

        //Question8: Given a list of Strings, join them into a single String separated by commas
        List<String> stringList1 = Arrays.asList
                ("Virat", "Rohit", "Hardik", "Rahul", "Risabh", "Bhuvi", "Bumrah", "Shami", "Shubman");
        String resultString = stringList1.stream().collect(Collectors.joining(","));
        System.out.println("Question8 Result: " + resultString);

        //Question9: Given a list of Integers, find the max value
        List<Integer> integerList4 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> question9Result = integerList4.stream()
                .max((Integer val1, Integer val2) -> val1 - val2);
        question9Result
                .ifPresent((Integer element) -> System.out.println("Question9 Result: " + element));

        //Question10: Given a list of Integers, find the min value
        List<Integer> integerList5 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Optional<Integer> question10Result = integerList5.stream()
                .min((Integer val1, Integer val2) -> val1 - val2);
        question10Result
                .ifPresent((Integer element) -> System.out.println("Question10 Result: " + element));

        //Question11: Given a nested list of Integers, flatten the list into a single list of Integers
        List<List<Integer>> listList = Arrays.asList(
                Arrays.asList(1, 2, 3, 4, 5),
                Arrays.asList(6, 7, 8, 9, 10),
                Arrays.asList(11, 12, 13, 14, 15, 16)
        );
        List<Integer> resultList = listList.stream()
                .flatMap((List<Integer> list) -> list.stream()).toList();
        System.out.println("Question11 Result: " + resultList);

        //Question12: Given a list of Integers, find the average
        List<Integer> integerList6 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        OptionalDouble average = integerList6.stream().mapToInt((Integer i) -> i).average();
        average.ifPresent((double d) -> System.out.println("Average: " + d));

        //Question13: print first n natural numbers with given digit n = 10 given digit = 5
        Stream.iterate(0, (Integer n) -> n + 1)
                .filter((Integer i) -> String.valueOf(i).contains("5"))
                .limit(10)
                .forEach((Integer i) -> System.out.println(i));

        //Questions14: print String that begin with a and end with c in lexicographical order
        String[] stringArray = {"abc", "cde", "acd", "aec", "xyz"};
        Arrays.stream(stringArray)
                .filter((String s) -> s.startsWith("a") && s.endsWith("c"))
                .sorted()
                .forEach((String s) -> System.out.println(s));

        //Question15: Given a Student(int roll, int marks, String name) Get a map where key is roll
        //and value is name
        List<Student> studentList = Arrays.asList(new Student(110, 70, "abc"),
                new Student(101, 70, "bcd"),
                new Student(120, 60, "xyz")
        );
        Map<Integer, String> resultMap = studentList.stream()
                .collect(Collectors.
                        toMap((Student s) -> s.getRoll(), (Student s) -> s.getName()));
        System.out.println("Question15 Result: " + resultMap);

        //Question16: Given  String return its reverse String
        String name = "keshav";
        Stream<String> stringStream = IntStream.range(0, name.length())
                .mapToObj(i -> name.charAt(name.length() - 1 - i))
                .map((Character c) -> String.valueOf(c));
        String reverseName = stringStream.collect(Collectors.joining());
        System.out.println("Original Name: " + name);
        System.out.println("Reverse Name: " + reverseName);

        //Question17: Sort an int array in reverse order
        int[] array = {1, 2, 3, 4, 5, 6, 7, 54, 4, 8};
        int[] sortedArray = Arrays.stream(array)
                .mapToObj((int i) -> Integer.valueOf(i))
                .sorted((Integer val1, Integer val2) -> val2 - val1)
                .mapToInt((Integer i) -> i)
                .toArray();
        System.out.println("Original Array: " + Arrays.toString(array));
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));

        //Questions18:

    }
}
