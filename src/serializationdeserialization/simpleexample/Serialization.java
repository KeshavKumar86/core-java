package serializationdeserialization.simpleexample;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {
    public static void main(String[] args) {
        Employee employee = new Employee("Keshav", 26, 2400.87);
        System.out.println("Original Object: " + employee);
        String fileName = "keshav.ser";
        FileOutputStream fout;
        try {
            fout = new FileOutputStream(fileName);
            ObjectOutputStream outputStream = new ObjectOutputStream(fout);
            outputStream.writeObject(employee);
            outputStream.close();
            fout.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
/*
Original Object: Employee{name='Keshav', id=26, salary=2400.87}
 */