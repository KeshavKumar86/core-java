package designpattern.creational.builder;

public class Car {

    //mandatory properties
    private String engine;
    private int wheels;

    //optional properties
    private boolean sunroof;
    private boolean airbags;

    private  Car(CarBuilder builder){
        this.engine = builder.engine;
        this.wheels = builder.wheels;
        this.sunroof = builder.sunroof;
        this.airbags = builder.airbags;
    }
    @Override
    public String toString() {
        return "Car{" +
                "engine='" + engine + '\'' +
                ", wheels=" + wheels +
                ", sunroof=" + sunroof +
                ", airbags=" + airbags +
                '}';
    }
    public String getEngine() {
        return engine;
    }

    public int getWheels() {
        return wheels;
    }

    public boolean isSunroof() {
        return sunroof;
    }

    public boolean isAirbags() {
        return airbags;
    }
    public static class CarBuilder{

        private String engine;
        private int wheels;
        private boolean sunroof;
        private boolean airbags;

        public CarBuilder(String engine, int wheels){
            this.engine = engine;
            this.wheels = wheels;
        }
        public CarBuilder setSunroof(boolean sunroof){
            this.sunroof = sunroof;
            return  this;
        }
        public CarBuilder setAirbags(boolean airbags){
            this.airbags = airbags;
            return  this;
        }
        public Car build(){
            validateCar();
            return new Car(this);
        }

        private void validateCar() {
            if (wheels < 4) {
                throw new IllegalArgumentException("Wheels can't be less than 4");
            }
            if (engine == null || engine.isEmpty()) {
                throw new IllegalArgumentException("Engine can't be null or empty");
            }
            // If airbags are added, sunroof must also be installed (for demonstration purposes)
            if (airbags && !sunroof) {
                throw new IllegalArgumentException("Airbags can only be installed if the car has a sunroof.");
            }
        }

    }
}
