package designpattern.creational.factory;

public class Main {
    public static void main(String[] args) {
        TataCar car = TataCarFactory.getInstance("EVCar");
        TataCar car1 = TataCarFactory.getInstance("DieselCar");
        car.createCar();
        car1.createCar();
    }
}
