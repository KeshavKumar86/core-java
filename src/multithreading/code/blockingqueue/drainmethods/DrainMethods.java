package multithreading.code.blockingqueue.drainmethods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DrainMethods {
    public static void main(String[] args) {

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);

        for(int i=1; i<= 10; i++){
            try {
                blockingQueue.put("Element: " + i);
            } catch (InterruptedException e) {
                System.out.println("Thread Interrupted");
            }
        }


        Collection<String> dest = new ArrayList<>();
        //Removes at most the given number of available elements from this queue and adds them to
        // the given collection.
        blockingQueue.drainTo(dest, 5);
        System.out.println(dest);
        dest.clear();


        //Removes all available elements from this queue and adds them to the given collection.
        blockingQueue.drainTo(dest);
        System.out.println(dest);


    }
}
