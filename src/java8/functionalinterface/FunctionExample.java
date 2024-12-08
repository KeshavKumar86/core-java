package java8.functionalinterface;

import java8.stream.questions.findnthhighestsalary.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        Function<String, Integer> function = name -> name.length();
        System.out.println("Length of the 'Keshav Kumar' is: " + function.apply("Keshav Kumar"));

        Function<String, Integer> stringIntegerFunction = number -> Integer.valueOf(number);
        System.out.println("Integer value of String  \"243\": " + stringIntegerFunction.apply("243"));

        List<Student> studentList = Arrays.asList(
                new Student(1, 78, "Ritesh"),
                new Student(2, 88, "Ankur"),
                new Student(3, 80, "Vikas"),
                new Student(4, 82, "Lalit")
        );
        Function<List<Student>, List<Student>> function1 = list -> {
            List<Student> modifiedList = new ArrayList<>();
            for (Student student : list) {
                if (student.getName().startsWith("L")) {
                    modifiedList.add(student);
                }
            }
            return modifiedList;
        };
        System.out.println("Students name start with 'L': " + function1.apply(studentList));

        Function<List<Student>, List<Student>> function2 = list -> {
            List<Student> modifiedList = new ArrayList<>();
            for (Student student : list) {
                if (student.getMarks() > 80) {
                    modifiedList.add(student);
                }
            }
            return modifiedList;
        };
        System.out.println("Students having marks>80: " + function2.apply(studentList));

        //Function Chaining
        Function<String,String> function3 = name->name.toUpperCase();
        Function<String,String> function4 = name->name.substring(0,3);
        System.out.println("Result: " + function3.andThen(function4).apply("Keshav Kumar"));

        Function<Integer,Integer> function5 = number->number*3;
        Function<Integer,Integer> function6 = number->number*number;
        System.out.println("AndThen() Result: " + function5.andThen(function6).apply(3));
        System.out.println("compose() Result: " + function6.compose(function5).apply(3));

        Function<String,String> identityFunction = Function.identity();
        System.out.println("Identity Result: " + identityFunction.apply("Keshav"));


    }
}
