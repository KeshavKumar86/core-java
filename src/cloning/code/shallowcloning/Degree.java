package cloning.code.shallowcloning;

public class Degree {
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
