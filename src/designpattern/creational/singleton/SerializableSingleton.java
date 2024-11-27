package designpattern.creational.singleton;

import java.io.Serial;
import java.io.Serializable;

public class SerializableSingleton implements Serializable {
    private static SerializableSingleton instance;
    private SerializableSingleton(){

    }
    public static SerializableSingleton getInstance(){
        if(instance==null){
            instance = new SerializableSingleton();
        }
        return instance;
    }
    // This method will be called during deserialization it will return the same object
    @Serial
    protected  Object readResolve(){
        return instance;
    }

}
