package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparableEx1 {

    public static void main(String[] args) {
        List<Student1> list = new ArrayList<>();
        list.add(new Student1("Keshav",4));
        list.add(new Student1("Lalit",3));
        list.add(new Student1("Vikas",6));
        list.add(new Student1("Ankur",7));
        list.add(new Student1("Vikas",8));
        list.add(new Student1("Ankur",5));
        System.out.println("Unsorted Students: " + list);
        Collections.sort(list);
        System.out.println("Sorted Students: " + list);
        Collections.sort(list,new IdSort());
        System.out.println("Sorted Students: " + list);
    }

}
class Student1 implements Comparable<Student1>{
    String name;
    int id;
    Student1(String name,int id){
        this.name = name;
        this.id = id;
    }
    public String toString(){
        return this.id + " " + this.name;
    }

    @Override
    public int compareTo(Student1 o) {
        if(this.name.compareTo(o.name)==0)
        {
           return id-o.id;
        }
        return this.name.compareTo(o.name);
    }
}

class IdSort implements Comparator<Student1>{

    @Override
    public int compare(Student1 o1, Student1 o2) {
        return o1.id-o2.id;
    }
}