package multithreading.code.executorservice;

import java.util.concurrent.*;

public class ExecutorServiceEx1_1 {

    public static void main(String[] args) {

        int corePoolSize = 10;
        int maxPoolSize = 20;
        long keepAliveTime = 3000;

        Executor threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(128)
        );
        threadPoolExecutor =
                Executors.newFixedThreadPool(3);//corePoolSize = 3 and maxPoolSize = 3

        ScheduledExecutorService scheduledExecutorService =
                new ScheduledThreadPoolExecutor(corePoolSize);
    }

}
/*

Let’s break down the code and its concepts related to different types of thread pools.

Code Walkthrough:
ThreadPoolExecutor with Core and Max Pool Size:

Executor threadPoolExecutor = new ThreadPoolExecutor(
    corePoolSize,
    maxPoolSize,
    keepAliveTime,
    TimeUnit.MILLISECONDS,
    new ArrayBlockingQueue<>(128)
);
Core pool size: Number of threads that are kept alive even when idle.
Max pool size: The maximum number of threads allowed in the pool.
Keep-alive time: If a thread is idle for more than this time, it is terminated (only for threads above
the core size).
Queue: Tasks that exceed the current pool size are placed in the ArrayBlockingQueue (fixed size: 128).
If the queue is full, additional tasks will be rejected or handled by a RejectedExecutionHandler.


Overriding threadPoolExecutor with newFixedThreadPool:

threadPoolExecutor = Executors.newFixedThreadPool(3);
This replaces the previous ThreadPoolExecutor.
A fixed thread pool of 3 threads is created where core size and max size are both 3. No threads will be
terminated once created.
Scheduled Thread Pool:

ScheduledExecutorService scheduledExecutorService =
        new ScheduledThreadPoolExecutor(corePoolSize);
This pool is used to schedule tasks for delayed or repeated execution.
It behaves like a thread pool but allows scheduling at fixed rates or intervals.
Behavior and Use Cases:
1. ThreadPoolExecutor:
Suitable when you want fine control over core size, max size, keep-alive time, and the queueing policy.
If the pool’s size is between the core size and max size, new threads will be created for incoming tasks.
Once the pool reaches max size, new tasks are placed in the queue. If the queue is full, a rejection
policy applies.
Use Case:
Handling tasks with dynamic or bursty loads. Threads are created and removed as needed based on demand.

2. Fixed Thread Pool (newFixedThreadPool):
This creates a pool with a fixed number of threads. If a thread finishes executing, it is reused for
the next task.
No threads are removed, even if they remain idle for a long time.
Use Case:
Useful for limited resources where the number of threads is capped to avoid overloading the system.

3. Scheduled Thread Pool (ScheduledThreadPoolExecutor):
Allows delayed and repeated execution of tasks.
Example: Running periodic tasks like cron jobs.
Use Case:
Useful for executing tasks at fixed intervals (e.g., sending heartbeat messages or polling).
Summary:
ThreadPoolExecutor: Highly configurable, suited for dynamic workloads.
Fixed Thread Pool: Simple, fixed-size pool to handle a known set of tasks.
Scheduled Thread Pool: Used for delayed or periodic task execution.
This code demonstrates how different thread pools can be created based on the requirements of
task management and resource control.
 */