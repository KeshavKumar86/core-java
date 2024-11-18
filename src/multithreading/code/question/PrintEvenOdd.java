package multithreading.code.question;

public class PrintEvenOdd {
    private static final MonitorObject monitorObject = new MonitorObject();
    private static int i = 0;

    public static void main(String[] args) {
        System.out.println("main thread starting");
        Thread evenThread = new Thread(() -> {
            while (i <= 10) {
                System.out.println(i);
                i++;
                monitorObject.doNotify();
                monitorObject.doWait();

            }
        });
        Thread oddThread = new Thread(() -> {
            while (i <= 10) {
                monitorObject.doWait();
                if (i <= 10) {
                    System.out.println(i);
                }
                i++;
                monitorObject.doNotify();

            }
        });

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