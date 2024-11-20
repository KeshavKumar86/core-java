package serializationdeserialization.customserialization.example2;

import java.io.*;

public class Employee implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private transient String password;

    public Employee(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    @Serial
    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.defaultWriteObject();
        outputStream.writeObject(new StringBuilder(password).reverse().toString());
        outputStream.writeObject("SERIAL-" + name);
        outputStream.writeInt(age * 2);
    }

    @Serial
    private void readObject(ObjectInputStream inputStream) throws IOException, ClassNotFoundException {
        inputStream.defaultReadObject();
        this.password = new StringBuilder((String) inputStream.readObject()).reverse().toString();
        String serialName = (String) inputStream.readObject();
        this.name = serialName.substring(7);
        this.age = inputStream.readInt() / 2;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", password='" + password + '\'' +
                '}';
    }
}
