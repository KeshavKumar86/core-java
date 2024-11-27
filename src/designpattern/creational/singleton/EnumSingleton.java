package designpattern.creational.singleton;

public enum EnumSingleton {
    INSTANCE;
    public void doSomething(){
        System.out.println("Method inside enum");
    }
}
