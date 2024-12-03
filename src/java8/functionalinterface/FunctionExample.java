package java8.functionalinterface;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {

        /*
        Function is a functional interface inside map intermediate operation of stream API.
        Applies this function to the given argument.
        @param t the function argument
        @return the function result
        R apply(T t);
         */
        Function<Integer, Integer> integerFunction = (Integer i) -> i * 2;
        System.out.println("Double of 4 is: " + integerFunction.apply(4));

    }
}
