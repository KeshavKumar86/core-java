package cloning.code.shallowcloning;

public class Address {
    private final City city;
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
}
