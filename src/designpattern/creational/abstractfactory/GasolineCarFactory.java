package designpattern.creational.abstractfactory;

public class GasolineCarFactory implements CarFactory{
    @Override
    public Engine createEngine() {
        return new GasolineEngine();
    }

    @Override
    public Tires createTires() {
        return new GasolineTires();
    }
}
