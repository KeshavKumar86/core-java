package cloning.code.deepcloning.manualdeepcopy;

public class City implements Cloneable {
    private String name;
    private final String pin;

    public City(String name, String pin) {
        this.name = name;
        this.pin = pin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", pin='" + pin + '\'' +
                '}';
    }

    @Override
    public City clone() {
        try {
            //copy mutable state here, so the clone can't change the internals of the original
            return (City) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
