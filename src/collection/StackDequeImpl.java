package collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class StackDequeImpl {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.size());
        //traversal using iterator
        Iterator<Integer> itr = stack.iterator();
        while(itr.hasNext())
             System.out.print(itr.next()+" ");
        System.out.println("\n"+stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        System.out.println(stack.peek());
        System.out.println(stack);


    }
}
