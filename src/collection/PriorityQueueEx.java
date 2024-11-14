package collection;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PriorityQueueEx {
    public static void main(String[] args) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        pq.add("Keshav");
        pq.add("Lalit");
        pq.add("Ankur");
        pq.add("Yadav");
        pq.add("Ritesh");
        pq.add("Brett");

        System.out.println(pq.size());
        System.out.println(pq);
        System.out.println(pq.peek());
        System.out.println(pq.remove());
        System.out.println(pq.peek());
        System.out.println(pq);

        pq.add("Ankur");
        pq.add("Ankur");
        System.out.println(pq);
        Iterator<String> itr = pq.iterator();
        while ((itr.hasNext())){
            System.out.print(itr.next()+" ");
        }




    }
}
