package serializationdeserialization.customserialization.example1;

import java.io.*;

public class CustomSerializationMain {
    public static void main(String[] args) {

        String file = "custom.ser";
        //Serialization of Student object
        Student student = new Student("Keshav", 27, "abcxyz");
        System.out.println("Original Student : " + student);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(student);
            fileOutputStream.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Deserialization of student object
        Student deserializedStudent;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream inputStream = new ObjectInputStream(fileInputStream);
            deserializedStudent = (Student) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Serialized and Deserialized Object: " + deserializedStudent);
    }
}
/*
Custom Serialization Logic
You can customize serialization using the following methods in your class:

private void writeObject(ObjectOutputStream oos) throws IOException
private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException

The java.io.NotActiveException: not in call to writeObject error occurs when you try to invoke the
defaultWriteObject() or defaultReadObject() methods outside of the serialization context (i.e., outside
the custom writeObject or readObject methods).

Why This Happens
The defaultWriteObject() and defaultReadObject() methods are special methods that operate in the
context of the ObjectOutputStream and ObjectInputStream during serialization and deserialization.
They must be called from within the corresponding writeObject and readObject methods of the class
being serialized.

**Correct Usage of writeObject and readObject
You can use these methods only within the private writeObject and readObject methods of a class.

Common Mistakes to Avoid
Calling defaultWriteObject() or defaultReadObject() outside writeObject or readObject methods:
These methods can only be used within their respective serialization methods.
Incorrectly handling transient fields:
If a transient field is critical, ensure it is serialized and deserialized manually.
Missing private access modifier for custom methods:
The writeObject and readObject methods must be private to work properly with Java's serialization
framework.
 */
