package cloning.code.cloneableinterface;

public class Employee implements Cloneable {
    private final String name;
    private final int age;
    private final String company;

    public Employee(String name, int age, String company) {
        this.name = name;
        this.age = age;
        this.company = company;
    }

    @Override
    public Employee clone() {
        try {
            // copy mutable state here, so the clone can't change the internals of the original
            return (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", company='" + company + '\'' +
                '}';
    }
}
