package java8.optional.code;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {

        /*
        Returns an empty Optional instance. No value is present for this Optional
         */
        Optional<String> optional = Optional.empty();
        System.out.println(optional);

        String fullName = "Virat Kohli";
        Optional<String> optionalString1 = Optional.ofNullable(fullName);
        System.out.println(optionalString1.get());

        /*
        Returns an Optional describing the given non-null value.
         */
        Optional<String> optionalString = Optional.of("Keshav");
        System.out.println(optionalString.get());

        /*
        If a value is present, returns true, otherwise false
         */
        Optional<String> optionalName = Optional.of("Virat Kohli");
        if (optionalName.isPresent()) {
            System.out.println(optionalName.get());
        }

        /*
        public void ifPresent(Consumer<? super T> action )
        If a value is present, performs the given action with the value, otherwise does nothing.
         */
        Optional<String> optionalString2 = Optional.of("Rohit Sharma");
        optionalString1.ifPresent((String name) -> System.out.println(name));

        /*
        If a value is present, returns the value, otherwise returns other.
         */
        Optional<Integer> optionalInteger = Optional.of(5);
        System.out.println(optionalInteger.orElse(0));

        /*
        public T orElseGet(Supplier<? extends T> supplier )
        If a value is present, returns the value, otherwise returns the result produced
        by the supplying function.
         */
        Optional<Integer> integer = Optional.of(46);
        System.out.println(integer.orElseGet(() -> 0));

        /*
        orElseThrow(): Returns the value if present, otherwise throws an exception (customizable)
         */
        Optional<Integer> integer1 = Optional.of(874);
        System.out.println(integer1.orElseThrow(() -> new IllegalArgumentException("Value is Missing")));

       /*
        Also, as of Java 11, we can do the opposite with the isEmpty method:
        */
        if (optional.isEmpty()) {
            System.out.println("Tested isEmpty() method");
        }

        /*
        Java 10 introduced a simplified no-arg version of orElseThrow() method. In case of an empty
        Optional it throws a NoSuchElementException:
         */
        Optional<String> stringOptional = Optional.ofNullable(null);
        //stringOptional.orElseThrow();

        /*
        filter(): Returns an Optional containing the value if it satisfies a given condition,
        otherwise returns an empty Optional.
        The filter method is normally used this way to reject wrapped values based on a predefined
        rule. We could use it to reject a wrong email format or a password that is not strong enough.
         */
        //without optional
        String name1 = "Virat";
        if(name1!=null && !name1.isEmpty() && name1.length()>4){
            System.out.println("Virat Length is greater than 4");
        }
        //with optional
        Optional<String> name = Optional.of("Virat");
        name.filter((String s) -> s.length() > 4)
                .ifPresent((String temp)-> System.out.println("Virat Length is greater than 4"));

        /*
        The map method however takes the existing value, performs a computation using this value,
        and returns the result of the computation wrapped in an Optional object:
         */
        List<String> list = Arrays.asList("Microsoft","Amazon","Oracle","Adobe","Atlassian");
        Optional<List<String>> optionalList = Optional.of(list);
        Optional<Integer> result = optionalList.map((List<String> stringList)->stringList.size());
        result.ifPresent((Integer res)-> System.out.println(res));





    }
}
