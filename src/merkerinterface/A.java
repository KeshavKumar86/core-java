package merkerinterface;

public class A implements Cloneable {
    private final int number;
    private final String name;

    public A(int number, String name) {
        this.number = number;
        this.name = name;
    }
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}
