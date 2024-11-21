package cloning.code.shallowcloning;

public class City {
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
}
