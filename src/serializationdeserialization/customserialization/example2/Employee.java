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
        this.age = inputStream.readInt() / 2;
        this.name = serialName.substring(7);
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
/*
Write Order Matters:

When data is written using ObjectOutputStream, it is stored in the exact sequence in which it is
written.
During deserialization with ObjectInputStream, you must read the data in the same order it was written.

Contract Between writeObject and readObject:
The sequence and data types of the fields in writeObject must exactly match those in readObject.
Otherwise, deserialization will fail with errors such as ClassCastException or
StreamCorruptedException.

What Happens If the Order is Wrong?
If the readObject calls do not match the order and type of writeObject, you might encounter:

ClassCastException:
Example: If you try to cast the result of readObject() to String but it was serialized as an Integer,
the program will fail.

StreamCorruptedException:
Occurs when the serialized data format does not match the expected format.

Silent Logical Errors:
If the fields are read out of order but the data types happen to match, you might get incorrect
values without an immediate exception.

 */