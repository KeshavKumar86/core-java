package multithreading.code.threadintro;

public class ThreadStop {
    public static class StoppableRunnable implements Runnable {
        private boolean stopRequested = false;

        public synchronized void requestStop() {
            stopRequested = true;
        }

        public synchronized boolean isStopRequested() {
            return stopRequested;
        }

        private void sleep(long millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        @Override
        public void run() {
            System.out.println("StoppableRunnable running");
            while(!isStopRequested()){
                sleep(1000);
                System.out.println("...");
            }
            System.out.println("StoppableRunnable stopped");
        }
    }

    public static void main(String[] args) {
        StoppableRunnable stoppableRunnable = new StoppableRunnable();
        Thread thread = new Thread(stoppableRunnable, "The Thread");
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("requesting stop");
        stoppableRunnable.requestStop();
        System.out.println("stop requested");
    }
}
/*
This code demonstrates a graceful stopping mechanism for a thread in Java using a custom
StoppableRunnable class. It avoids the deprecated and unsafe method Thread.stop() by using
a flag (stopRequested) that the thread checks regularly to determine whether it should stop running.
 */

/*
Key Points:
Thread Safety: The stopRequested flag is accessed via synchronized methods to prevent race conditions.

Graceful Stopping: Instead of forcefully terminating the thread, we signal the thread to stop,
and it checks the flag periodically. This is a cleaner and safer approach.

Thread Sleep: The sleep(1000) call in the loop simulates a task running periodically every second,
but it can be interrupted or stopped by the flag.

Synchronized Methods: By making requestStop() and isStopRequested() synchronized, the code ensures
that changes to the stopRequested flag are properly visible across multiple threads
(main thread and the worker thread).

This pattern is commonly used for long-running tasks or background threads that need to stop
based on external signals.
 */