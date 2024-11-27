package designpattern.creational.singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestingClass {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException, CloneNotSupportedException {
//        LazySingleton lazySingleton = LazySingleton.getInstance();
//        System.out.println(lazySingleton.hashCode());
//        LazySingleton lazySingleton1 = LazySingleton.getInstance();
//        System.out.println(lazySingleton1.hashCode());

//        EagerSingleton eagerSingleton = EagerSingleton.getInstance();
//        System.out.println(eagerSingleton.hashCode());
//        EagerSingleton eagerSingleton1 = EagerSingleton.getInstance();
//        System.out.println(eagerSingleton1.hashCode());

//          EagerSingleton.staticPrintSomeThing();

//          exampleSerialization();
//            exampleReflection();
            exampleClonable();

    }

    private static void exampleClonable() throws CloneNotSupportedException {
//        CloneSingletonBreaking instance = CloneSingletonBreaking.getInstance();
//        CloneSingletonBreaking secondInstance = instance.clone();
//        System.out.println(instance.hashCode());
//        System.out.println(secondInstance.hashCode());

        CloneableSingleton instance = CloneableSingleton.getInstance();
        CloneableSingleton secondInstance = instance.clone();
        System.out.println(instance.hashCode());
        System.out.println(secondInstance.hashCode());
    }

    private static void exampleReflection() throws InvocationTargetException, InstantiationException, IllegalAccessException {
//        Constructor<?>[] constructors = LazySingleton.class.getDeclaredConstructors();
//        Constructor<?> constructor = constructors[0];
//        constructor.setAccessible(true);
//        LazySingleton lazySingleton = (LazySingleton) constructor.newInstance();
//        LazySingleton lazySingleton1 = (LazySingleton) constructor.newInstance();
//        LazySingleton instance = LazySingleton.getInstance();
//        LazySingleton instance1 = LazySingleton.getInstance();
//        System.out.println("Reflected hashCode singleton: " + lazySingleton.hashCode());
//        System.out.println("Reflected hashCode singleton: " + lazySingleton1.hashCode());
//        System.out.println("Non Reflected hashCode singleton: " + instance.hashCode());
//        System.out.println("Non Reflected hashCode singleton: " + instance1.hashCode());

          //solution to this is go by enum
//          EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
//          enumSingleton.doSomething();

        Constructor<?>[] constructors = ReflectionSingleton.class.getDeclaredConstructors();
        Constructor<?> constructor = constructors[0];
        constructor.setAccessible(true);
        ReflectionSingleton reflectionSingleton = (ReflectionSingleton) constructor.newInstance();
        ReflectionSingleton reflectionSingleton1 = (ReflectionSingleton) constructor.newInstance();
        ReflectionSingleton instance = ReflectionSingleton.getInstance();
        ReflectionSingleton instance1 = ReflectionSingleton.getInstance();
        System.out.println("Reflected hashCode singleton: " + reflectionSingleton.hashCode());
        System.out.println("Reflected hashCode singleton: " + reflectionSingleton1.hashCode());
        System.out.println("Non Reflected hashCode singleton: " + instance.hashCode());
        System.out.println("Non Reflected hashCode singleton: " + instance1.hashCode());

    }

    private static void exampleSerialization() throws IOException, ClassNotFoundException {
        LazySingleton originalObject = LazySingleton.getInstance();
        ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("obj.text"));
        outputStream.writeObject(originalObject);
        outputStream.close();

        LazySingleton deserializedObject;
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("obj.text"));
        deserializedObject = (LazySingleton) inputStream.readObject();
        //let's check whether the object is same
        System.out.println(originalObject.hashCode());
        System.out.println(deserializedObject.hashCode());

          SerializableSingleton originalObject1 = SerializableSingleton.getInstance();
          ObjectOutputStream outputStream1 = new ObjectOutputStream(new FileOutputStream("obj1.txt"));
          outputStream1.writeObject(originalObject1);
          outputStream1.close();

          SerializableSingleton deserializedObject1;
          ObjectInputStream inputStream1 = new ObjectInputStream(new FileInputStream("obj1.txt"));
          deserializedObject1 = (SerializableSingleton) inputStream1.readObject();
          inputStream1.close();

          //check whether 2 objects are equal
        System.out.println("Serializable Singleton: " + originalObject1.hashCode());
        System.out.println("Serializable Singleton: "+ deserializedObject1.hashCode());



    }

}
