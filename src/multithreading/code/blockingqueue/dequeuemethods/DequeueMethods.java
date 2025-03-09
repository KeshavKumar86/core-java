package multithreading.code.blockingqueue.dequeuemethods;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class DequeueMethods {
    public static void main(String[] args) {

        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(4);

        //Retrieves and removes the head of this queue, waiting if necessary until an element becomes
        // available.
        try {
            Integer element = blockingQueue.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Retrieves and removes the head of this queue, or returns null if this queue is empty.
        blockingQueue.poll();

        //Retrieves and removes the head of this queue, waiting up to the specified wait time if
        // necessary for an element to become available.
        try {
            blockingQueue.poll(1000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Removes a single instance of the specified element from this queue, if it is present.
        // More formally, removes an element e such that o.equals(e), if more than 1 element matches
        //then removes the first element
        boolean result = blockingQueue.remove(1);
    }
}
