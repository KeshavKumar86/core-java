package multithreading.code.threadintro;

public class ThreadJoin {
    public static void main(String[] args) {
        Runnable runnable = ()->{
            for(int i=0;i<5;i++){
                sleep(1000);
                System.out.println("Running");
            }
        };
        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void sleep(long millis){
        try{
            Thread.sleep(millis);
        }
        catch(InterruptedException e){
           e.printStackTrace();
        }
    }
}

/*
The join() method in Java allows one thread to wait for the completion of another thread.
When one thread calls join() on another thread, it pauses the execution of the calling thread
until the thread on which join() was invoked completes. This is particularly useful when you want
to ensure that a particular thread finishes its task before proceeding with the rest of the code
in the calling thread.

How join() Works:
When a thread calls the join() method on another thread, the following happens:

The calling thread (which calls join()) is put into a waiting state.
The target thread (the thread on which join() is called) continues its execution.
Once the target thread has completed its execution (i.e., it terminates either normally or due to an
exception), the calling thread is resumed and continues its execution from the point after join() was
called.
 */
