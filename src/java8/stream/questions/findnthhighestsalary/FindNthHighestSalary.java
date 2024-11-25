package java8.stream.questions.findnthhighestsalary;

import java.util.*;
import java.util.stream.Collectors;

public class FindNthHighestSalary {
    public static void main(String[] args) {

        int n = 3;
        Map<String, Integer> map = new HashMap<>();
        map.put("Anil", 1000);
        map.put("Bhavna", 1200);
        map.put("Micheal", 1000);
        map.put("Tom", 1300);
        map.put("Ankit", 1200);
        map.put("Daniel", 1300);
        map.put("James", 1200);
        nthHighestSalary(map, n);
    }

    private static void nthHighestSalary(Map<String, Integer> map, int n) {
        /*Optional<Map.Entry<String, Integer>> optionalEntry = map.entrySet().stream()
                .sorted((Map.Entry<String, Integer> val1, Map.Entry<String, Integer> val2)
                        -> val1.getValue() - val2.getValue())
                .skip(map.size() - n).findFirst();
        optionalEntry.ifPresent((Map.Entry<String,Integer> entry)-> System.out.println("Result: " + entry.getKey()));*/

        /*Map.Entry<String,Integer> entry = map.entrySet()
                .stream()
                .sorted((Map.Entry<String, Integer> val1, Map.Entry<String, Integer> val2)
                -> val2.getValue() - val1.getValue())
                .distinct()
                .toList().get(n-1);
        System.out.println("Result: " + entry.getKey());*/

        Map<Integer, List<String>> collect = map.entrySet().stream()
                .collect(Collectors
                        .groupingBy(entry->entry.getValue(),
                                Collectors.mapping(entry-> entry.getKey(), Collectors.toList())));
        Map.Entry<Integer, List<String>> result = collect.entrySet().stream()
                .sorted((Map.Entry<Integer, List<String>> val1,
                         Map.Entry<Integer, List<String>> val2)
                        -> val2.getKey() - val1.getKey()).toList().get(n - 1);
        System.out.println("Result: " + result);
    }

}
/*
Find Nth highest salary using Java Stream
 */