package serializationdeserialization.customserialization.example2;

import java.io.*;

public class CustomSerializationExample2 {
    public static void main(String[] args) {
        String file = "example2.ser";
        FileOutputStream fileOutputStream;
        ObjectOutputStream outputStream;
        FileInputStream fileInputStream;
        ObjectInputStream inputStream;

        //Serialization
        Employee employee = new Employee("Keshav", 27, "kuchbhi");
        System.out.println("Original Employee: " + employee);
        try {
            fileOutputStream = new FileOutputStream(file);
            outputStream = new ObjectOutputStream(fileOutputStream);
            outputStream.writeObject(employee);
            outputStream.close();
            fileOutputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //deserialization
        Employee deserializedStudent;
        try {
            fileInputStream = new FileInputStream(file);
            inputStream = new ObjectInputStream(fileInputStream);
            deserializedStudent = (Employee) inputStream.readObject();
            inputStream.close();
            fileInputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Employee After Serialization: " + deserializedStudent);
    }
}
/*

Java's ObjectOutputStream and ObjectInputStream provide methods to handle serialization and
deserialization of various primitive data types and objects. Here’s a comprehensive list of
methods available for writing and reading different data types:

Methods in ObjectOutputStream for Writing Data
Method	Purpose
writeObject(Object obj)	Writes an object to the stream.
writeInt(int v)	Writes an int value.
writeBoolean(boolean v)	Writes a boolean value.
writeByte(int v)	Writes a byte value.
writeChar(int v)	Writes a char value.
writeShort(int v)	Writes a short value.
writeLong(long v)	Writes a long value.
writeFloat(float v)	Writes a float value.
writeDouble(double v)	Writes a double value.
writeUTF(String s)	Writes a String in UTF-8 format.
writeBytes(String s)	Writes a String as a sequence of bytes.
writeChars(String s)	Writes a String as a sequence of characters.
write(byte[] b)	Writes a byte array.
write(byte[] b, int off, int len)	Writes a portion of a byte array.
Methods in ObjectInputStream for Reading Data
Method	Purpose
readObject()	Reads an object from the stream.
readInt()	Reads an int value.
readBoolean()	Reads a boolean value.
readByte()	Reads a byte value.
readChar()	Reads a char value.
readShort()	Reads a short value.
readLong()	Reads a long value.
readFloat()	Reads a float value.
readDouble()	Reads a double value.
readUTF()	Reads a String in UTF-8 format.
read(byte[] b)	Reads a byte array.
read(byte[] b, int off, int len)	Reads a portion of a byte array.
Examples
Writing Data with ObjectOutputStream:

try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
    oos.writeInt(123);               // Write an integer
    oos.writeBoolean(true);          // Write a boolean
    oos.writeDouble(456.78);         // Write a double
    oos.writeUTF("Hello, World!");   // Write a string in UTF format
    oos.writeChar('A');              // Write a character
} catch (IOException e) {
    e.printStackTrace();
}
Reading Data with ObjectInputStream:
java
Copy code
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"))) {
    int intValue = ois.readInt();             // Read an integer
    boolean boolValue = ois.readBoolean();    // Read a boolean
    double doubleValue = ois.readDouble();    // Read a double
    String stringValue = ois.readUTF();       // Read a string
    char charValue = ois.readChar();          // Read a character

    System.out.println("Integer: " + intValue);
    System.out.println("Boolean: " + boolValue);
    System.out.println("Double: " + doubleValue);
    System.out.println("String: " + stringValue);
    System.out.println("Character: " + charValue);
} catch (IOException e) {
    e.printStackTrace();
}
Matching Methods for Primitive Types
When you write a value using one method, you must read it using the corresponding method:

writeInt() ↔ readInt()
writeBoolean() ↔ readBoolean()
writeByte() ↔ readByte()
writeChar() ↔ readChar()
writeShort() ↔ readShort()
writeLong() ↔ readLong()
writeFloat() ↔ readFloat()
writeDouble() ↔ readDouble()
writeUTF() ↔ readUTF()
Handling Arrays
You can also write and read arrays of bytes directly using the write(byte[] b) and read(byte[] b)
methods:

Example:
byte[] data = {1, 2, 3, 4, 5};

// Writing byte array
try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("array.ser"))) {
    oos.write(data);
} catch (IOException e) {
    e.printStackTrace();
}

// Reading byte array
try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("array.ser"))) {
    byte[] readData = new byte[5];
    ois.read(readData);
    System.out.println("Byte array: " + java.util.Arrays.toString(readData));
} catch (IOException e) {
    e.printStackTrace();
}
Best Practices
Always match the write and read methods to avoid mismatched data types.
Use writeUTF and readUTF for strings to handle encoding correctly.
Handle EOFException for reading streams when the end of the stream is reached unexpectedly.
For custom serialization, ensure you use writeObject and readObject within the appropriate contexts.
These methods provide a versatile way to serialize and deserialize various data types efficiently.
 */