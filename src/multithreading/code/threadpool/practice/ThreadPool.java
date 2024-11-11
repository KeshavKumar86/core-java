package multithreading.code.threadpool.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ThreadPool {

    private BlockingQueue<Runnable> blockingQueue = null;
    private final List<PoolThreadRunnable> list = new ArrayList<>();

    private boolean isStopped = false;
    public ThreadPool(int noOfThreads, int noOfTasks) {
        blockingQueue = new ArrayBlockingQueue<>(noOfTasks);
        for(int i=0;i<noOfThreads;i++){
            PoolThreadRunnable poolThreadRunnable = new PoolThreadRunnable(blockingQueue);
            list.add(poolThreadRunnable);
        }
        for(PoolThreadRunnable runnable : list){
            new Thread(runnable).start();
        }
    }

    public synchronized void execute(Runnable runnable) {
        if(isStopped){
            throw new IllegalStateException("Thread pool is stopped");
        }
        blockingQueue.offer(runnable);
    }

    public synchronized void waitUntilAllTaskFinished() {
        while(!blockingQueue.isEmpty()){
            sleep();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public synchronized void stop() {
        isStopped = true;
        for(PoolThreadRunnable runnable : list){
            runnable.doStop();
        }
    }
}
