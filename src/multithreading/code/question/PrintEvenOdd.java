package multithreading.code.question;

public class PrintEvenOdd {
    private static int i = 0;
    private static final Object obj = new Object();

    public static void main(String[] args) {
        System.out.println("main thread starting");
        Thread evenThread = new Thread(() -> {
            while (i <= 10) {
                synchronized (obj) {
                    if (i <= 10 && i % 2 == 0) {
                        System.out.println(i);
                        i++;
                        try {
                            obj.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }

            }
        }, "even");
        Thread oddThread = new Thread(() -> {
            while (i <= 10) {
                synchronized (obj) {
                    if (i <= 10 && i % 2 != 0) {
                        System.out.println(i);
                        i++;
                        obj.notify();
                    }
                }
            }
        }, "odd");

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("main thread exiting");
    }
}
/*
Print even odd using 2 threads in synchronized manner
 */