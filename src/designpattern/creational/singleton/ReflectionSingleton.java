package designpattern.creational.singleton;

public class ReflectionSingleton {
    private static ReflectionSingleton instance;
    private static boolean  isInstanceCreated = false;
    private ReflectionSingleton(){
        if(isInstanceCreated){
            throw new RuntimeException("use getInstance() method to create Singleton instance");
        }
        isInstanceCreated = true;
    }
    public static ReflectionSingleton getInstance(){
        if(instance == null){
            instance = new ReflectionSingleton();
        }
        return instance;
    }
}
