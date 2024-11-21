package cloning.code.deepcloning.manualdeepcopy;

import java.util.Arrays;
import java.util.List;

public class DeepCloningExample {
    public static void main(String[] args) {

        Degree degree = new Degree("MBA", 90);
        City city = new City("Delhi", "201312");
        Address address = new Address(city, "Delhi", "INDIA");
        List<String> companies = Arrays.asList("RCB", "Delhi");
        Person person = new Person("Virat", 25, 200000, address, companies, degree);

        Person clone = person.clone();
        //test if it is really a deep copy
        clone.setName("Virat Kohli");//will not change original because deep copy
        clone.getAddress().getCity().setName("New Delhi"); //will not change original
        // because deep copy
        clone.getDegree().setName("MBBS");//will not change original because deep copy

        System.out.println("Original Person: " + person);
        System.out.println("Clone Person: " + clone);
    }
}
