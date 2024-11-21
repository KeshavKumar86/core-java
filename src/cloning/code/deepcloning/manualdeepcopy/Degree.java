package cloning.code.deepcloning.manualdeepcopy;

public class Degree implements Cloneable {
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

    @Override
    public Degree clone() {
        try {
            //copy mutable state here, so the clone can't change the internals of the original
            return (Degree) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
