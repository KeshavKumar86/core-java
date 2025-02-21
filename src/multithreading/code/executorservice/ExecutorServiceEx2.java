package multithreading.code.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceEx2 {
    public static void main(String[] args) {

        //ExecutorService executorService = Executors.newFixedThreadPool(1);
        ExecutorService executorService = Executors.newSingleThreadExecutor();//same as above

        executorService.execute(newRunnable("Task 1.1"));
        executorService.execute(newRunnable("Task 1.2"));
        executorService.execute(newRunnable("Task 1.3"));

        executorService.shutdown();
    }

    private static Runnable newRunnable(String msg) {
        return new Runnable() {
            @Override
            public void run() {
                String completeMsg = Thread.currentThread().getName() + ": " + msg;
                System.out.println(completeMsg);
            }
        };
    }
}
