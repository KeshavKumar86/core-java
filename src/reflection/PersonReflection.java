package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class PersonReflection {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> personClass = Class.forName("reflection.Person");
        //Person person = new Person("Keshav", 25);
        Field[] personFields = personClass.getDeclaredFields();
        System.out.println("-------------Fields---------------------");
        for(Field field : personFields){
            System.out.println(field.getType() + " " + field.getName() + ";");
        }
        Field[] personFields1 = personClass.getFields();

        for(Field field : personFields1){
            System.out.println(field.getType() + " " + field.getName() + ";");
        }
        System.out.println("-------------Methods---------------------");
        Method[] personMethods = personClass.getDeclaredMethods();
        for(Method method : personMethods){
            System.out.println( method.getReturnType() + " " + method.getName() + "();");
        }
        System.out.println("-------------Constructors---------------------");
        Constructor<?>[] constructors = personClass.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors){
            System.out.println(constructor);
        }
    }

}
