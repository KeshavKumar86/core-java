package java8.stream.questions;

import java.util.*;

public class FindNthHighestSalary {
    public static void main(String[] args) {
        List<Integer> integerList = Arrays.asList(1, 4, 3, 2, 5, 7, 6, 8);
        int n = 2;
        nthHighestNumber(integerList, n);
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

        Map.Entry<String,Integer> entry = map.entrySet()
                .stream()
                .sorted((Map.Entry<String, Integer> val1, Map.Entry<String, Integer> val2)
                -> val2.getValue() - val1.getValue())
                .distinct()
                .toList().get(n-1);
        System.out.println("Result: " + entry.getKey());
    }

    private static void nthHighestNumber(List<Integer> integerList, int n) {
        Optional<Integer> optionalInteger = integerList.stream()
                .sorted()
                .skip((integerList.size() - n)).findFirst();
        optionalInteger.ifPresent((Integer i) -> System.out.println("Result: " + i));

    }
}
/*
Find Nth highest salary using Java Stream
 */