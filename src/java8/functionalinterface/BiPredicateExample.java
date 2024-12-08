package java8.functionalinterface;

import java.util.function.BiPredicate;

public class BiPredicateExample {
    public static void main(String[] args) {

        /*
          Evaluates this predicate on the given arguments.
          @param t the first input argument
          @param u the second input argument
          @return {@code true} if the input arguments match the predicate,
          otherwise {@code false}

        boolean test(T t, U u);
         */
        BiPredicate<Integer, Integer> biPredicate = (Integer num1, Integer num2) ->
                num1 % 2 == 0 && num2 % 2 == 0;
        System.out.println("BiPredicate Result: " + biPredicate.test(2, 8));
    }
}
