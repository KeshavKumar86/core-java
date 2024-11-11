package collection;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapEx {
    public static void main(String[] args) {
        //creating HashMap
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Keshav");
        map.put(2,"Lalit");
        map.put(3,"Ankur");
        map.put(4,"Ritesh");
        map.put(1,"Keshav Kumar");
        System.out.println("Initial Size of map: " + map.size());
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        Iterator<Map.Entry<Integer,String>> itr = set.iterator();
        while(itr.hasNext()){
            Map.Entry<Integer,String> entry = itr.next();
            System.out.print("Key: " + entry.getKey()+" Value: "
            + entry.getValue()+", ");
        }
        System.out.println();
        for(int key=1;key<=map.size();key++)
        {
            System.out.print("Value: " + map.get(key) + ", ");
        }
        System.out.println();
        map.remove(4);
        System.out.println("Current Size of map: " + map.size());
        System.out.println("Current State: " + map);

    }

}
