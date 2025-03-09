package multithreading.code.blockingqueue.peekmethods;

import java.util.NoSuchElementException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class PeekMethods {
    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        blockingQueue.add("element1");
        blockingQueue.add("element2");
        blockingQueue.add("element3");

        //Retrieves, but does not remove, the head of this queue, or returns null if this queue
        // is empty.
        String firstElement = blockingQueue.peek();
        System.out.println(firstElement);

        blockingQueue.poll();
        //Retrieves, but does not remove, the head of this queue. This method differs from peek
        // only in that it throws an exception if this queue is empty
        try{
            String topElement = blockingQueue.element();
            System.out.println(topElement);
        }
        catch (NoSuchElementException e){
            System.out.println(e);
        }

        blockingQueue.clear();
        try{
            String topElement = blockingQueue.element();
            System.out.println(topElement);
        }
        catch (NoSuchElementException e){
            System.out.println(e);
        }


    }
}
