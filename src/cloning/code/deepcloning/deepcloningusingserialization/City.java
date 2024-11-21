package cloning.code.deepcloning.deepcloningusingserialization;

import java.io.Serial;
import java.io.Serializable;

public class City implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
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
