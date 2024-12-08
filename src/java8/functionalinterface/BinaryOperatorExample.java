package java8.functionalinterface;

import java.util.function.BinaryOperator;

public class BinaryOperatorExample {
    public static void main(String[] args) {

        /*
        It is same as BiFunction<T,T,T>
         */
        BinaryOperator<String> binaryOperator = (String firstName, String surName) ->
                firstName + " " + surName;

        System.out.println("Full Name: " + binaryOperator.apply("Virat", "Kohli"));
    }
}
