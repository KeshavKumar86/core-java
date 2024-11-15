package merkerinterface;

public class ADemo {
    public static void main(String[] args) throws CloneNotSupportedException {
        A a = new A(5,"Keshav");
       // a.clone(); 'clone()' has protected access in 'java.lang.Object'
        //Now A class implements Cloneable interface so we can clone its object

        // cloning 'a' and holding
        // new cloned object reference in b

        // down-casting as clone() return type is Object
        A b = (A)a.clone();
        System.out.println("Number: " + b.getNumber() + " Name: " + b.getName());
        System.out.println(a.hashCode() + " != " + b.hashCode());
    }
}
