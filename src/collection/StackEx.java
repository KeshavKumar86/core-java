package collection;

import java.util.Iterator;
import java.util.Stack;

public class StackEx {

    public static void main(String args[])
    {
        // Creating an empty Stack
        Stack<Integer> stack = new Stack<Integer>();

        // Use add() method to add elements
        stack.push(10);
        stack.push(15);
        stack.push(30);
        stack.push(20);
        stack.push(5);

        //traversing stack using iterator
        Iterator<Integer> itr = stack.iterator();
        while(itr.hasNext())
            System.out.println("Iterator traversal of stack: "+ itr.next());

        // Displaying the Stack
        System.out.println("Initial Stack: " + stack);

        System.out.println("Initial Size: " + stack.size());

        //searching element
        System.out.println("Found Element at position: "+ stack.search(5));

        // Removing elements using pop() method
        System.out.println("Popped element: "
                + stack.pop());
        System.out.println("Popped element: "
                + stack.pop());

        System.out.println("Current Size: " + stack.size());

        // Displaying the Stack after pop operation
        System.out.println("Stack after pop operation "
                + stack);


    }
}
