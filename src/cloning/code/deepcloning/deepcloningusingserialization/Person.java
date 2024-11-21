package cloning.code.deepcloning.deepcloningusingserialization;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class Person implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private final int age;
    private final double salary;
    private Address address;
    private final List<String> companies;
    private final Degree degree;

    public Person(String name, int age, double salary, Address address, List<String> companies, Degree degree) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.address = address;
        this.companies = companies;
        this.degree = degree;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Degree getDegree() {
        return degree;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", address=" + address +
                ", companies=" + companies +
                ", degree=" + degree +
                '}';
    }
}
