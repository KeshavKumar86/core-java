package java8.functionalinterface;

import java8.stream.questions.findnthhighestsalary.Student;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {

        Consumer<String> consumer = name -> System.out.println(name);
        consumer.accept("Virat Kohli");

        List<Student> studentList = Arrays.asList(
                new Student(1, 78, "Ritesh"),
                new Student(2, 88, "Ankur"),
                new Student(3, 80, "Vikas"),
                new Student(4, 82, "Lalit")
        );
        Consumer<List<Student>> consumer1 = list -> {
            for (Student student : list) {
                System.out.println(student.getName());
            }
        };

        Consumer<List<Student>> consumer2 = list -> {
            for (Student student : list) {
                System.out.println(student.getName().toUpperCase());
            }
        };

        consumer1.andThen(consumer2).accept(studentList);
    }
}

