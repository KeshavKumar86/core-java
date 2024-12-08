package java8.functionalinterface;

import java.util.function.UnaryOperator;

public class UnaryOperatorExample {
    public static void main(String[] args) {

        /* It is same as Function<T,T>
        For UnaryOperator return type and parameter type
        of apply function will be same.
        when return type and parameter type
        of apply function is same than we can use UnaryOperator instead of Function
         */
        UnaryOperator<Integer> function = (Integer i) -> i * 4;
        System.out.println("Result: " + function.apply(16));


    }
}
