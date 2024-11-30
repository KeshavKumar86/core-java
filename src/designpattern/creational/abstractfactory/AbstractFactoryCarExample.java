package designpattern.creational.abstractfactory;

public class AbstractFactoryCarExample {

    public static void main(String[] args) {
        CarFactory carFactory = new ElectricCarFactory();
        CarManufacturer electricCar = new CarManufacturer(carFactory);
        electricCar.manufactureCar();

        carFactory = new GasolineCarFactory();
        CarManufacturer gasolineCar = new CarManufacturer(carFactory);
        gasolineCar.manufactureCar();
    }

}
