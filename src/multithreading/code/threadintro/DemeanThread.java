package multithreading.code.threadintro;

public class DemeanThread {

    public static void main(String[] args) {
         Runnable runnable = ()->{
            while(true){
                sleep(1000);
                System.out.println("Running");
            }
        };
         Thread thread = new Thread(runnable);
         thread.setDaemon(true);
         /* Marks this thread as a daemon thread.
         The Java virtual machine terminates when all started non-daemon threads have terminated
         so all daemon thread will also get terminate but this will leave daemon thread to an
         undefined state.*/
         thread.start();
         sleep(3000);
        System.out.println("main thread is exiting");
    }
    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
/* when we did not make thread as daemon thread->
Once the main thread finishes sleeping for 3 seconds, it exits the main method and the main thread
terminates. However, the new thread keeps running indefinitely, as it’s stuck in an infinite loop.
because other thread is running it will not allow JVM to die, so JVM will be alive until you get stack
overflow exception.
The thread will not stop unless the JVM is terminated manually (e.g., by stopping the program),
or you explicitly stop the thread, which is not done in this code.
 */
