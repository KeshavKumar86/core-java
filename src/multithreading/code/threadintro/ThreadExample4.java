package multithreading.code.threadintro;

public class ThreadExample4 {
    static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            System.out.println("Runnable running");
            Thread.currentThread()
                    .setName("Thread implementation using runnable implementation using inner class");
            System.out.println(Thread.currentThread().getName());
            System.out.println("Runnable finished");
        }
    };

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Thread thread = new Thread(runnable);
        thread.start();
        //thread.run();
        System.out.println(Thread.currentThread().getName());
    }
}
/* when we call thread.run() method directly then output will be below- (only one thread will run)
main
Runnable running
Thread implementation using runnable implementation using inner class
Runnable finished
Thread implementation using runnable implementation using inner class
 */

/* when we call thread.start() method then output will be any of the below
main
main
Runnable running
Thread implementation using runnable implementation using inner class
Runnable finished

Thread Scheduling: When you start a new thread using thread.start(),
the main thread continues executing its own instructions without waiting
for the new thread to finish. This means that the output from the main thread
may be printed before the new thread starts executing. Thread execution order is
controlled by the Java thread scheduler, and it does not guarantee when the new thread
will start or finish relative to the main thread.
-------------------------OR---------------------------------------------------
main
Runnable running
Thread implementation using runnable implementation using inner class
Runnable finished
main


 */