package collection;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorEx {
    public static void main(String[] args) {

        List<Student1> list = new ArrayList<>();
        list.add(new Student1("Keshav",4));
        list.add(new Student1("Lalit",3));
        list.add(new Student1("Vikas",6));
        list.add(new Student1("Ankur",7));
        list.add(new Student1("Vikas",8));
        list.add(new Student1("Ankur",5));

        ListIterator<Student1> lit = list.listIterator();
//        System.out.println(lit.hasPrevious());
        System.out.println(lit.next());
        System.out.println(lit.next());
        System.out.println(lit.next());
        System.out.println(lit.next());
        System.out.println(lit.previous());
        lit.set(new Student1("Ankur Singh",7));
        lit.add(new Student1("Ritesh",9));
        System.out.println(list);

        System.out.println(lit.hasPrevious());
        System.out.println(lit.previous());
        while(lit.hasNext()){
            System.out.print(lit.next() + " ");
        }
        System.out.println();
        while(lit.hasPrevious()){
            System.out.print(lit.previous() + " ");
        }
        System.out.println();
        while(lit.hasNext()){
            System.out.print(lit.next() + " ");
        }
    }
}
