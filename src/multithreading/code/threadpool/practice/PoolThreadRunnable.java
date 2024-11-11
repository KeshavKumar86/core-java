package multithreading.code.threadpool.practice;

import java.util.concurrent.BlockingQueue;

public class PoolThreadRunnable implements Runnable {

    private boolean isStopped = false;
    private Thread thread;
    private BlockingQueue<Runnable> blockingQueue = null;

    public PoolThreadRunnable(BlockingQueue<Runnable> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }
    @Override
    public synchronized void run() {

        while (!isStopped()) {
            this.thread = Thread.currentThread();
            try {
                Runnable task = blockingQueue.take();
                task.run();
            } catch (InterruptedException e) {
                //log or otherwise report exception
                // but keep thread pool alive
            }
        }
    }
    private synchronized boolean isStopped() {
        return isStopped;
    }

    public synchronized void doStop() {
        isStopped = true;
        //break pool thread out of deque call
        thread.interrupt();
    }

}
