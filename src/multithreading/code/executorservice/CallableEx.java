package multithreading.code.executorservice;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ExecutionException;

public class CallableEx {
    public static void main(String[] args) {
        Callable<Integer> task = ()->{
           //do some task
           return 46;
        };
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(task);
        System.out.println(future.isDone());
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(future.isDone());
        executorService.shutdown();
    }
}
