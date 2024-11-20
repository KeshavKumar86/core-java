package serializationdeserialization.transientstatic;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Vikas", 60, "abc**");
        System.out.println("Original Employee: " + employee);

        //Serialization
        String fileName = "vikas.ser";
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(employee);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Employee.setSalary(67000);
        employee.setName("Vikas Yadav");
        //Deserialization
        Employee deserializedEmployee = getDeserializedEmployee(fileName);
        System.out.println("Deserialized Employee: " + deserializedEmployee);

    }

    private static Employee getDeserializedEmployee(String fileName) {
        Employee deserializedEmployee;
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        try {
            fileInputStream = new FileInputStream(fileName);
            objectInputStream = new ObjectInputStream(fileInputStream);
            deserializedEmployee = (Employee) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return deserializedEmployee;
    }
}
