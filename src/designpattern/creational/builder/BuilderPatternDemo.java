package designpattern.creational.builder;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        //building a basic car
        Car basicCar = new Car.CarBuilder("V8",4).build();
        System.out.println(basicCar);
        //building a luxury car
        Car luxuryCar = new Car.CarBuilder("V8",4)
                .setSunroof(true)
                .setAirbags(true)
                .build();
        System.out.println(luxuryCar);

        try{
            Car invalidCar1 = new Car.CarBuilder("V6", 3).build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            // Invalid car: no engine specified
            Car invalidCar2 = new Car.CarBuilder("", 4).build(); // Throws exception
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());  // The car must have a valid engine.
        }
    }
}
