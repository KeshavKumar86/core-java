package java8.stream;

import java.util.ArrayList;
import java.util.List;

public class StreamExample1 {
    public static void main(String[] args) {
        List<Double> salary = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            double v = Math.random() * 10_000;
            salary.add(v);
        }
        //you have to count total number of salary greater than 2000 using traditional loops
        int count = 0;
        for (Double element : salary) {
            if (element > 5000) {
                count++;
            }
        }
        System.out.println("Total Number of Salary>5000: " + count);

        //Now count using java 8 Stream
        long result;
        result = salary.stream().filter((Double element) -> element > 5000).count();
        System.out.println("Total Number of Salary>5000 using java Stream: " + result);
    }
}
