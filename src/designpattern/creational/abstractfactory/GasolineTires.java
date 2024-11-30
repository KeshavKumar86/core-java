package designpattern.creational.abstractfactory;

public class GasolineTires implements Tires{
    @Override
    public void designTires() {
        System.out.println("Designing tires for gasoline car");
    }
}
