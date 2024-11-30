package designpattern.creational.abstractfactory;

public interface CarFactory {
    Engine createEngine();
    Tires createTires();
}
