package java8.stream.parallelstream;

import java.util.Arrays;
import java.util.List;

public class ForEachOrdered {
    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        numbers.parallelStream()
                .forEach((Integer i)-> System.out.println(
                        Thread.currentThread().getName() + " - " + i));  //without ordered
        //it will print in any random order

        System.out.println("Separation Print Statement");

        numbers.parallelStream()
                .forEachOrdered((Integer i)-> System.out.println(
                        Thread.currentThread().getName() + " - " + i));  //with ordered
        //it will print in the insertion order;
    }
}
