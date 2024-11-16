package reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CatReflection {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Cat cat  =new Cat("Stella", 6);
        System.out.println("-----------------------Fields------------------------");
        Field[] catFields = cat.getClass().getDeclaredFields();
        //cat.name = "Bella"; cannot access because it is private
        for (Field field : catFields){
            if(field.getName().equals("name")){
               // field.set(cat, "Jimmy Mcgill"); cannot access a member of class
                // reflection.Cat with modifiers "private final"
                field.setAccessible(true);
                field.set(cat, "Jimmy Mcgill"); // now we can access it because setAccessible is true
            }
        }
        System.out.println(cat.getName());
        System.out.println("------------------Methods----------------------------");
        Method[] catMethods = cat.getClass().getDeclaredMethods();
        for (Method method : catMethods){
//            if(method.getName().equals("meow")){
//                method.invoke(cat);
//                cat.meow();
//                cat.heyThisIsPrivate();
//            }
            //if(method.getName().equals("heyThisIsPrivate")){
                //method.invoke(cat); //cannot access a member of class reflection.Cat
                // with modifiers "private"
                //cat.heyThisIsPrivate(); //can't access because this is private
                //method.setAccessible(true);
                //cat.heyThisIsPrivate(); //can't access because this is private
                //method.invoke(cat);
            //}
//            if(method.getName().equals("thisIsPublicStaticMethod")){
//                method.invoke(null);
//                Cat.thisIsPublicStaticMethod();
//            }

            if(method.getName().equals("thisIsPrivateStaticMethod")){
                //method.invoke(null); //cannot access a member of class reflection.Cat
                // with modifiers "static private"
                //Cat.heyThisIsPrivate(); //can't access because this is private
                method.setAccessible(true);
                //cat.heyThisIsPrivate(); //can't access because this is private
                method.invoke(null);
            }
        }

    }
}
