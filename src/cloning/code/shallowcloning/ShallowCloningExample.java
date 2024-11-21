package cloning.code.shallowcloning;

import java.util.Arrays;
import java.util.List;

public class ShallowCloningExample {
    public static void main(String[] args) {

        Degree degree = new Degree("MBA", 90);
        City city = new City("Delhi", "201312");
        Address address = new Address(city, "Delhi", "INDIA");
        List<String> companies = Arrays.asList("RCB", "Delhi");
        Person person = new Person("Virat", 25, 200000, address, companies, degree);

        Person clone = person.clone();
        //test if it is really a shallow copy
        clone.setName("Virat Kohli");//will not change original because not inside nested object
        clone.getAddress().getCity().setName("New Delhi"); //will change original because shallow copy
        clone.getDegree().setName("MBBS");//will change original

        System.out.println("Original Person: " + person);
        System.out.println("Clone Person: " + clone);
    }
}
