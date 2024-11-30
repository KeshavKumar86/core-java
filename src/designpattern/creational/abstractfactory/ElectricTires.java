package designpattern.creational.abstractfactory;

public class ElectricTires implements Tires{
    @Override
    public void designTires() {
        System.out.println("Designing tires for electric car");
    }
}
