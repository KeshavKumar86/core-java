package java8.functionalinterface;

import java8.stream.questions.findnthhighestsalary.Student;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {

        /*
           Gets a result.
           @return a result
           T get();
         */
        Supplier<String> supplier = () -> {
            return "Keshav";
        };
        System.out.println("Result: " + supplier.get());

        Supplier<Student> studentSupplier = () -> new Student(18, 65, "Virat Kohli");
        System.out.println("StudentSupplier Result: " + studentSupplier.get());
    }
}
