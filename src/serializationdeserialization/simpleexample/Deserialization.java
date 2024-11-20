package serializationdeserialization.simpleexample;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialization {
    public static void main(String[] args) {
        String fileName = "keshav.ser";
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        Employee employee;
        try {
            fileInputStream = new FileInputStream(fileName);
            objectInputStream = new ObjectInputStream(fileInputStream);
            employee = (Employee) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("After Deserialization: " + employee);
    }
}
