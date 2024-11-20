package serializationdeserialization.deepcloning;

import java.io.Serial;
import java.io.Serializable;

public class Person implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private final String name;
    private final int age;
    private final double salary;
    private final Address address;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }

    public Person(String name, int age, double salary, Address address) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.address = address;
    }
}
