package serializationdeserialization.deepcloning;

import java.io.*;

public class DeepCloningExample {
    public static void main(String[] args) {
        //create address object
        Address address = new Address("Noida", "UP", "India");
        //create Person Object
        Person person = new Person("Keshav", 25, 45000, address);

        System.out.println("Serialized Person: " + person);

        //serialization
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
        Person deserilizedPerson;
        try {
            byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            inputStream = new ObjectInputStream(byteArrayInputStream);
            deserilizedPerson = (Person) inputStream.readObject();
            inputStream.close();
            byteArrayInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Deserialize Person: " + deserilizedPerson);
    }
}
/*
1. Deep Cloning using Serialization
Deep cloning involves creating an exact copy of an object, including all objects it references,
ensuring that changes to the cloned object do not affect the original.

How Serialization Helps in Deep Cloning
Serialization converts an object into a byte stream, and deserialization reconstructs it into a new
object. This ensures that all referenced objects are also deeply copied.
 */