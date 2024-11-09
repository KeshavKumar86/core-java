package collection;

import java.util.*;

public class IteratorEx {
    public static void main(String[] args) {

        List<Student1> list = new ArrayList<>();
        list.add(new Student1("Keshav",4));
        list.add(new Student1("Lalit",3));
        list.add(new Student1("Vikas",6));
        list.add(new Student1("Ankur",7));
        list.add(new Student1("Vikas",8));
        list.add(new Student1("Ankur",5));

        Iterator<Student1> it = list.iterator();
        System.out.println(list);
        //it.remove();
        while(it.hasNext()){
            Student1 s = it.next();
            System.out.println(s);
            if(s.name.equals("Vikas"))
                it.remove();
        }
        Iterator<Student1> it1 = list.iterator();
        it1.next();
        it1.remove();

        System.out.println(list);

        Vector<Integer> v =new Vector<>();
        for(int i=0;i<10;i++)
            v.add(i);
        Enumeration<Integer> e = v.elements();
        while(e.hasMoreElements())
            System.out.print(e.nextElement()+" ");
    }
}
