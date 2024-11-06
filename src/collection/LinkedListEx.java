package collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedListEx {

    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<>();
        ll.add("Geeks");
        ll.add("Geeks");
        ll.add(1,"Geeks");
        System.out.println(ll);
        ll.set(1, "For");

        Iterator<String> itr = ll.iterator();
        while(itr.hasNext())
            System.out.print(itr.next()+" ");

        ll.remove();
        System.out.println();
        System.out.println(ll);
        System.out.println(ll.size());

        //creating new list
        List<Integer> list = Arrays.asList(new Integer[]{1,2,3,4,5});
        Iterator<Integer> i = list.iterator();
        while(i.hasNext())
            System.out.print(i.next()+" ");

        LinkedList<String> list1 = new LinkedList<>(ll);
        System.out.println();
        for(int j = 0; j<list1.size(); j++)
            System.out.print(list1.get(j)+" ");
        System.out.println();
        System.out.print(list1);
        System.out.println();
        Object[] arr = list1.toArray();
        for(Object element: arr)
            System.out.print(element+" ");



    }

}
