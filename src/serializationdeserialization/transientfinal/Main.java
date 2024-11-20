package serializationdeserialization.transientfinal;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        Student student = new Student("Ankur", 36);
        System.out.println("Original Student: " + student);
        //serialization
        String fileName = "ankur.ser";
        FileOutputStream fileOutputStream;
        ObjectOutputStream objectOutputStream;
        try {
            fileOutputStream = new FileOutputStream(fileName);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(student);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //deserialization
        Student deserializedStudent = getDeserializedStudent(fileName);
        System.out.println("Deserialized Student: " + deserializedStudent);
    }

    private static Student getDeserializedStudent(String fileName) {
        Student deserializedStudent;
        FileInputStream fileInputStream;
        ObjectInputStream objectInputStream;
        try {
            fileInputStream = new FileInputStream(fileName);
            objectInputStream = new ObjectInputStream(fileInputStream);
            deserializedStudent = (Student) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return deserializedStudent;
    }
}
