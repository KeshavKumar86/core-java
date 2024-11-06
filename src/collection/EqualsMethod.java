package collection;

public class EqualsMethod {

    public static  void main(String [] args){
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = s1;
        System.out.println(s1.equals(s2));
        System.out.println(s1.equals(s3));
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s3.hashCode());



    }

}
class Student{
    String name;
    String id;

}
