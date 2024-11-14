package collection;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(queue.size());
        System.out.println(queue.peek());
        System.out.println(queue);
        queue.remove();
        System.out.println(queue.size());
        System.out.println(queue);
        System.out.println(queue.peek());
    }
}
