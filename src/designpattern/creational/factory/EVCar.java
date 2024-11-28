package designpattern.creational.factory;

public class EVCar implements TataCar{
    @Override
    public void createCar() {
        System.out.println("EV car is created with motor and battery");
    }
}
