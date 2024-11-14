package collection;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeueEx {
    public static void main(String[] args) {
        Deque<Integer> queue = new ArrayDeque<>();
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

        queue.addLast(6);
        System.out.println(queue.peek());
        System.out.println(queue);




    }
}
