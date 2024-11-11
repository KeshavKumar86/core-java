package collection;

import java.util.*;

public class LinkedHashMapEx {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(4,"Four");
        map.put(6,"Six");
        map.put(8,"Eight");
        map.put(5,"Five");
        map.put(7,"Seven");
        map.put(3,"Three");
        System.out.println(map);

        LinkedHashMap<Integer,String> lmap = new LinkedHashMap<>();
        lmap.put(4,"Four");
        lmap.put(6,"Six");
        lmap.put(8,"Eight");
        lmap.put(5,"Five");
        lmap.put(7,"Seven");
        lmap.put(3,"Three");
        lmap.put(null,"null");
        lmap.put(null,"null");
        System.out.println(lmap.size());
        System.out.println(lmap);
        lmap.remove(5);
        System.out.println(lmap.size());
        Set<Map.Entry<Integer,String>> set =  lmap.entrySet();
        Iterator<Map.Entry<Integer,String>> itr = set.iterator();
        while(itr.hasNext()){
            Map.Entry<Integer,String> entry = itr.next();
            System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());
        }
    }
}
