package cloning.code.deepcloning.deepcloningusingserialization;

import java.io.Serial;
import java.io.Serializable;

public class Degree implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String name;
    private final double percentage;

    public Degree(String name, double percentage) {
        this.name = name;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Degree{" +
                "name='" + name + '\'' +
                ", percentage=" + percentage +
                '}';
    }
}
