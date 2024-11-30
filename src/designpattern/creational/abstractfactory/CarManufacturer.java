package designpattern.creational.abstractfactory;

public class CarManufacturer {
    Engine engine;
    Tires tires;
    public CarManufacturer(CarFactory factory){
        engine = factory.createEngine();
        tires = factory.createTires();
    }
    public void manufactureCar(){
        engine.designEngine();;
        tires.designTires();
    }

}
