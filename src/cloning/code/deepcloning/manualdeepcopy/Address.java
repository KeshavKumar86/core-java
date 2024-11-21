package cloning.code.deepcloning.manualdeepcopy;

public class Address implements Cloneable {
    private City city;
    private String state;
    private final String country;

    public Address(City city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public Address clone() {
        try {
            // copy mutable state here, so the clone can't change the internals of the original
            Address address = (Address) super.clone();
            address.setCity(city.clone());
            return address;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
