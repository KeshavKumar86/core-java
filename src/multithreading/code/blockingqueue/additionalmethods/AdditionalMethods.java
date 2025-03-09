package multithreading.code.blockingqueue.additionalmethods;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class AdditionalMethods {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println("Size: " + blockingQueue.size());
        System.out.println("Capacity: " + blockingQueue.remainingCapacity());

        blockingQueue.add("Element1");
        blockingQueue.add("Element2");

        System.out.println("Size: " + blockingQueue.size());
        System.out.println("Contains Element1: " + blockingQueue.contains("Element1"));
        System.out.println("Remaining Capacity: " + blockingQueue.remainingCapacity());
    }
}
