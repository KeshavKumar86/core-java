package multithreading.code.executorservice.practice1;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SingleThreadPoolMain {
    public static void main(String[] args) {
        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        //submit 10 task to the singleThreadPoolExecutor, it will execute sequentially
        List<Future<?>> futureList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            Future<?> future = singleThreadPool.submit(getRunnable("Task" + i));
            futureList.add(future);
            System.out.println(future.isDone());
        }

        for (int i = 0; i < 10; i++) {
            try {
                futureList.get(i).get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }

        }
        for (int i = 0; i < 10; i++) {
            System.out.println(futureList.get(i).isDone());
        }
        singleThreadPool.shutdown();
        System.out.println("main thread exiting");

    }

    private static Runnable getRunnable(String msg) {
        return () -> {
            System.out.println(Thread.currentThread().getName() + " msg");
        };
    }
}
