package java8.functionalinterface;

import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        BiConsumer<Integer,String> biConsumer = (Integer num,String name)->
                System.out.println(name + " jersey number is " + num);

        biConsumer.accept(18,"Virat Kohli");

    }
}
