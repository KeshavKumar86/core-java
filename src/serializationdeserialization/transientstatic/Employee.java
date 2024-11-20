package serializationdeserialization.transientstatic;

import java.io.Serializable;

public class Employee implements Serializable {
    private String name;
    private int id;
    private static double salary = 240000;
    private transient String password;

    public Employee(String name, int id, String password) {
        this.name = name;
        this.id = id;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", password='" + password + '\'' +
                ", salary='" + salary + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public static void setSalary(double salary) {
        Employee.salary = salary;
    }

}
