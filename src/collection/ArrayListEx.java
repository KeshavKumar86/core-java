package collection;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListEx {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<>();
        System.out.println(al);
        System.out.println(al.size());
        al.add("Geeks");
        al.add("Geeks");
        System.out.println(al);
        al.add(1,"For");
        for(String s: al)
            System.out.println(s);
        Collections.sort(al);
        for(int i=0;i<al.size();i++)
        {
            System.out.print(al.get(i)+ " ");
        }
        al.set(1,"Keshav");
        System.out.println(al);
        al.remove("Keshav");
        System.out.println(al);
        al.remove(1);
        System.out.println(al);

        ArrayList<String> list = new ArrayList<>(5);
        System.out.println(list.size());

    }
}
