package cloning.code.deepcloning.deepcloningusingserialization;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class DeepCloningSerializationExample {
    public static void main(String[] args) {

        Degree degree = new Degree("MBA", 90);
        City city = new City("Delhi", "201312");
        Address address = new Address(city, "Delhi", "INDIA");
        List<String> companies = Arrays.asList("RCB", "Delhi");
        Person person = new Person("Virat", 25, 200000, address, companies, degree);

        ByteArrayOutputStream byteArrayOutputStream;
        ObjectOutputStream outputStream;
        ByteArrayInputStream byteArrayInputStream;
        ObjectInputStream inputStream;

        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            outputStream = new ObjectOutputStream(byteArrayOutputStream);
            outputStream.writeObject(person);
            outputStream.close();
            byteArrayOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //deserialization
        Person clone;
        try {
            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            inputStream = new ObjectInputStream(byteArrayInputStream);
            clone = (Person) inputStream.readObject();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Original Person: " + person);
        //test if it is actual deep copy
        clone.setName("Virat Kohli");//will not change original because deep copy
        clone.getAddress().getCity().setName("New Delhi"); //will not change original
        // because deep copy
        clone.getDegree().setName("MBBS");//will not change original because deep copy
        System.out.println("Clone Person: " + clone);
    }
}
