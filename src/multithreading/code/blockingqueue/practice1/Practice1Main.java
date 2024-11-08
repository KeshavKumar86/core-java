package multithreading.code.blockingqueue.practice1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Practice1Main {
    public static void main(String[] args) {

        System.out.println("main thread starting");
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);

        Thread producer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    blockingQueue.put("" + i);
                    System.out.println("Produced Element: " + i);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    String element = blockingQueue.take();
                    System.out.println("Consumed Element: " + element);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
            consumer.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("main thread exiting");
    }
}
