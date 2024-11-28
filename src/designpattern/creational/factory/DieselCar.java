package designpattern.creational.factory;

public class DieselCar implements TataCar{
    @Override
    public void createCar() {
        System.out.println("Diesel car is created with Engine");
    }
}
