package designpattern.creational.singleton;

public class EagerSingleton {
    private static final EagerSingleton instance;
    static {
        instance = new EagerSingleton();
    }
    private EagerSingleton(){}

    public static EagerSingleton getInstance() {
        return instance;
    }
    public void  printSomeThing(){
        System.out.println("Instance Method");
    }
    public static void staticPrintSomeThing(){
        System.out.println("Static Method");
    }
}
