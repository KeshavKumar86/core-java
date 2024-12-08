package java8.functionalinterface;

import java.util.function.BiFunction;

public class BiFunctionExample {
    public static void main(String[] args) {

        /*
      Applies this function to the given arguments.
      @param t the first function argument
      @param u the second function argument
      @return the function result
      R apply(T t, U u);
        */
        BiFunction<Integer, Integer, Long> productFunction = (Integer a, Integer b) ->
                (long) a * b;
        System.out.println("BiFunction Result: " + productFunction.apply(2, 7));
    }
}
