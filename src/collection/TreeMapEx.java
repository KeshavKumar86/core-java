package collection;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapEx {
    public static void main(String[] args) {
        TreeMap<Integer,String> treemap = new TreeMap<>();
        //add elements
        treemap.put(4,"Four");
        treemap.put(7,"Seven");
        treemap.put(8,"Eight");
        treemap.put(9,"Nine");
        treemap.put(2,"Two");
        treemap.put(5,"Five");
        treemap.put(3,"Three");
        treemap.put(7,"UpdatedSeven");
        System.out.println(treemap.size());
        System.out.println(treemap);

        //Constructor with SortedMap parameter
        TreeMap<Integer,String> tm = new TreeMap<>(treemap.subMap(3,7));
        tm.put(6,"Six");
        System.out.println(tm);

        //headMap method
        tm = new TreeMap<>(treemap.headMap(9,true));
        System.out.println(tm);

        //tailMap method
        tm = new TreeMap<>(treemap.tailMap(4));
        System.out.println(tm);
        tm.remove(7);
        System.out.println(tm);
        //Iteration
        Set<Map.Entry<Integer,String>> set  = tm.entrySet();
        Iterator<Map.Entry<Integer,String>> itr = set.iterator();
        while(itr.hasNext()){
            Map.Entry<Integer,String> entry = itr.next();
            System.out.println(entry);
        }

    }
}
