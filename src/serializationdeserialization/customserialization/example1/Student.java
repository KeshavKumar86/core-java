package serializationdeserialization.customserialization.example1;

import java.io.*;

public class Student implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String name;
    private final int age;
    private transient String password; //not serialized

    public Student(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    @Serial
    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();//write all instance fields
        outputStream.writeObject("Encrypted " + password);
    }

    @Serial
    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();//deserialize instance fields
        this.password = (String) inputStream.readObject();
        //String encryptedPassword = (String) inputStream.readObject();
        //this.password = encryptedPassword.substring(10);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
