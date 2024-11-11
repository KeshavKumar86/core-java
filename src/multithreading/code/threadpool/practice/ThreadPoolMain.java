package multithreading.code.threadpool.practice;

public class ThreadPoolMain {
    public static void main(String[] args) {
        int noOfTasks = 10;
        int noOfThreads = 3;
        ThreadPool threadPool = new ThreadPool(noOfThreads, noOfTasks);

        for(int i=0;i<10;i++){
            int finalI = i;
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName() + ": Task " + finalI);
            });
        }
        threadPool.waitUntilAllTaskFinished();
        threadPool.stop();

    }
}
