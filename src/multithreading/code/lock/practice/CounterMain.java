package multithreading.code.lock.practice;

import java.util.ArrayList;
import java.util.List;

public class CounterMain {
    public static void main(String[] args) {

        CounterLock counterLock = new CounterLock();
        System.out.println("main thread starting");
        System.out.println("Initial Count Value: " + counterLock.getCount());

        Runnable runnable = () -> {
            for (int i = 0; i < 10_000; i++) {
                counterLock.inc();
            }
        };

        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(runnable);
            list.add(thread);
            thread.start();
        }

        for (int i = 0; i < 10; i++) {
            try {
                list.get(i).join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Final Count Value: " + counterLock.getCount());
        System.out.println("main thread exiting");
    }
}
