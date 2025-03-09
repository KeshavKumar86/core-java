package multithreading.code.blockingqueue.example2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<>(2);
        new Thread(()->{

            try {
                System.out.println("Producer: Adding 1");
                blockingQueue.put(1);
                System.out.println("Producer: 1 Added");

                System.out.println("Producer: Adding 2");
                blockingQueue.put(2);
                System.out.println("Producer: 2 Added");

                System.out.println("Producer: Trying to add 3 (should block)");
                //this will be blocked because queue is full
                blockingQueue.put(3);
                System.out.println("Producer: 3 Added");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();

        new Thread(()->{

            try {
                Thread.sleep(1000); //Delay to let producer add the first 2 elements behaviour
                System.out.println("Consumer: Taking 1");
                System.out.println("Consumer: Removed " + blockingQueue.take());
                System.out.println("Consumer: Taking 2");
                System.out.println("Consumer: Removed " + blockingQueue.take());
                System.out.println("Consumer: Taking 3");
                System.out.println("Consumer: Removed " + blockingQueue.take());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();;
    }
}
/*
In Java, both Standard Queue and BlockingQueue are interfaces in the java.util package, but they serve different purposes. Here's a breakdown of their differences:

1. Standard Queue (java.util.Queue)
Non-blocking: It does not wait if the queue is full or empty; operations return immediately.
Behavior:
add() / offer(): Adds elements. If the queue is full, add() throws an exception, while offer() returns false.
remove() / poll(): Removes elements. If the queue is empty, remove() throws an exception, and poll() returns null.
Thread Safety: Not inherently thread-safe. For thread safety, you need to use synchronized blocks or thread-safe implementations like ConcurrentLinkedQueue.
Example:

java
Copy code
import java.util.LinkedList;
import java.util.Queue;

public class StandardQueueExample {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);

        System.out.println(queue.poll()); // Outputs: 1
        System.out.println(queue.poll()); // Outputs: 2
        System.out.println(queue.poll()); // Outputs: null (Queue is empty)
    }
}
2. BlockingQueue (java.util.concurrent.BlockingQueue)
Blocking behavior:
put(): Blocks if the queue is full, waiting for space to become available.
take(): Blocks if the queue is empty, waiting for an element to be available.
Thread Safety: Designed for use in multithreaded environments.
Usage: Often used in producer-consumer scenarios.
Common Implementations:
ArrayBlockingQueue
LinkedBlockingQueue
PriorityBlockingQueue
 */