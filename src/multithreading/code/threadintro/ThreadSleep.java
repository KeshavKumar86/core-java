package multithreading.code.threadintro;

import java.util.Arrays;

public class ThreadSleep {
    public static void main(String[] args) {
        Runnable runnable = ()->{
            System.out.println(Thread.currentThread().getName() + " is Running");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(Arrays.toString(e.getStackTrace()));
            }
            System.out.println(Thread.currentThread().getName() + " is Finished");
        };
        Thread thread1 = new Thread(runnable, "The Thread1");
        Thread thread2 = new Thread(runnable, "The Thread2");

        thread1.start();
        thread2.start();
    }
}
