package collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorEx {
    public static void main(String[] args) {
        List<Student1> list = new ArrayList<>();
        list.add(new Student1("Keshav",4));
        list.add(new Student1("Lalit",3));
        list.add(new Student1("Vikas",6));
        list.add(new Student1("Ankur",7));
        list.add(new Student1("Vikas",8));
        list.add(new Student1("Ankur",5));
        System.out.println("Unsorted Students: " + list);
        Collections.sort(list,new NameSort());

        System.out.println("sorted Students based on names: " + list);
        //search student using binary search
        System.out.println("Search Keshav: "+
                Collections.binarySearch(list,
                        new Student1("Keshav",4),new NameSort()));
        Collections.sort(list,new IdSort());
        System.out.println("sorted Students based on id: " + list);
        Collections.sort(list,new NameIdSort());
        System.out.println("sorted Students based on name & id: " + list);

    }
}
class NameSort implements Comparator<Student1>{

    @Override
    public int compare(Student1 o1, Student1 o2) {
        return o1.name.compareTo(o2.name);
    }
}
class NameIdSort implements Comparator<Student1>{

    @Override
    public int compare(Student1 o1, Student1 o2) {
        if(o1.name.compareTo(o2.name)==0)
            return o1.id-o2.id;
        return o1.name.compareTo(o2.name);
    }
}
