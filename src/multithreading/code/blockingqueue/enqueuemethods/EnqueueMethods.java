package multithreading.code.blockingqueue.enqueuemethods;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class EnqueueMethods {
    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(4);

        // put() method will be blocked if there is not space in the queue, and if it is interrupted
        //while blocked it will throw InterruptedException
        try {
            blockingQueue.put("1");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //add() method Inserts the specified element into this queue if it is possible to do so
        // immediately without violating capacity restrictions, returning true upon success and
        // throwing an IllegalStateException if no space is currently available.
        try {
            boolean flag = blockingQueue.add("2");
        } catch (IllegalStateException e) {
            System.out.println(e);
        }

        //Inserts the specified element into this queue if it is possible to do so immediately without
        // violating capacity restrictions, returning true upon success and false if no space is
        // currently available
        boolean result = blockingQueue.offer("3");

        //Inserts the specified element into this queue, waiting up to the specified wait time if
        // necessary for space to become available
        try {
            boolean result1 = blockingQueue.offer("4", 1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
