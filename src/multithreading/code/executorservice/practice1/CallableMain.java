package multithreading.code.executorservice.practice1;

import java.util.concurrent.*;

public class CallableMain {
    public static void main(String[] args) {

        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        Future<Object> future = singleThreadPool.submit(getCallable());
        System.out.println(future.isDone());
        System.out.println(future.isCancelled());
        System.out.println(future.state());
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        singleThreadPool.shutdown();
    }

    private static Callable<Object> getCallable() {
        return new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return Thread.currentThread().getName() + ": Task1";
            }
        };
    }
}
