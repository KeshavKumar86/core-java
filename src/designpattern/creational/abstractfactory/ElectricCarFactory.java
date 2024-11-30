package designpattern.creational.abstractfactory;

public class ElectricCarFactory implements CarFactory{
    @Override
    public Engine createEngine() {
        return new ElectricEngine();
    }

    @Override
    public Tires createTires() {
        return new ElectricTires();
    }
}
