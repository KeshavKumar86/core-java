package multithreading.code.compareandswap.casvslock;

import java.util.concurrent.atomic.AtomicInteger;

public class CASVsLockExample {
    private static final int ITERATION = 1_000_0000;
    private static final Object lock = new Object();
    private static final AtomicInteger atomicCounter = new AtomicInteger(0);
    private static int lockCounter = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread casThread = new Thread(() -> {
            for (int i = 0; i < ITERATION; i++) {
                atomicCounter.incrementAndGet(); // uses CAS internally
            }
        }, "CASThread");

        Thread lockThread = new Thread(() -> {
            for (int i = 0; i < ITERATION; i++) {
                synchronized (lock) {
                    lockCounter++;
                }
            }
        }, "LockThread");

        long startTime = System.nanoTime();
        casThread.start();
        casThread.join(); //wait for CASThread to finish
        long casDuration = System.nanoTime() - startTime;

        startTime = System.nanoTime();
        lockThread.start();
        lockThread.join();
        long lockDuration = System.nanoTime() - startTime;

        System.out.println("CAS Duration: " + casDuration / 1_000_000 + " ms");
        System.out.println("Lock Duration: " + lockDuration / 1_000_000 + " ms");
    }
}
