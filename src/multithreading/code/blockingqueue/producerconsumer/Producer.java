package multithreading.code.blockingqueue.producerconsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    BlockingQueue<String> blockingQueue = null;
    public Producer(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {

        while (true){
            long timeMillis = System.currentTimeMillis();
            try {
                this.blockingQueue.put("" + timeMillis);
            } catch (InterruptedException e) {
                System.out.println("Producer was interrupted");
            }
            sleep(1000);
        }
    }

    private void sleep(long  timeMillis) {
        try {
            Thread.sleep(timeMillis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
