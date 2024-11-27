package designpattern.creational.singleton;

public class CloneableSingleton implements Cloneable{
    private static final CloneableSingleton instance = new CloneableSingleton();

    private CloneableSingleton(){

    }
    public static CloneableSingleton getInstance(){
        return instance;
    }
    @Override
    public CloneableSingleton clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of this Singleton is not allowed");

    }
}
