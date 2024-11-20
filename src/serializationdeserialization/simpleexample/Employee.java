package serializationdeserialization.simpleexample;

import java.io.Serializable;

public class Employee implements Serializable {
    private final String name;
    private final int id;
    private final double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}
