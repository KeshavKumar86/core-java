package multithreading.code.compareandswap;

import java.util.concurrent.atomic.AtomicInteger;

public class CompareAndSwapExample {
    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(100); // initial value is 100

        boolean result = count.compareAndSet(100, 110);
        if (result) {
            System.out.println("Value updated to: " + count.get());
        } else {
            System.out.println("CAS failed. Current value: " + count.get());
        }

    }
}
