package multithreading.code.executorservice.practice1;

import java.util.concurrent.*;

public class FixedThreadPoolMain {
    public static void main(String[] args) {

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        /*Executor cachedThreadPool =
                new ThreadPoolExecutor(3,
                        6,
                        1000,
                        TimeUnit.MILLISECONDS,
                        new ArrayBlockingQueue<>(16));
        ScheduledExecutorService scheduledThreadPool = new ScheduledThreadPoolExecutor(3);*/


        //submit the task to the pool to execute them
        for(int i=1;i<=10;i++){
            fixedThreadPool.execute(getRunnable("Task: " + i));
        }
        fixedThreadPool.shutdown();
    }
    public static Runnable getRunnable(String msg){
        return ()->{
            System.out.println(Thread.currentThread().getName() + ": " + msg);
        };
    }
}
