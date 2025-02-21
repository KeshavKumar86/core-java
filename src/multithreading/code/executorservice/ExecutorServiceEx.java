package multithreading.code.executorservice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceEx {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.execute(newRunnable("Task 1"));
        executorService.execute(newRunnable("Task 2"));
        executorService.execute(newRunnable("Task 3"));
        executorService.execute(newRunnable("Task 4"));
        executorService.execute(newRunnable("Task 5"));
        executorService.execute(newRunnable("Task 6"));
        
        executorService.shutdown();
    }
    private static Runnable newRunnable(String msg) {
        return ()->{
            String completeMsg = Thread.currentThread().getName() + ": " + msg;
            System.out.println(completeMsg);
        };
    }
}
/*
Explanation of the Code:
This example demonstrates how to use an ExecutorService with a fixed thread pool to execute tasks
concurrently. Here's what happens step-by-step:

Creating ExecutorService with 3 Threads:

ExecutorService executorService = Executors.newFixedThreadPool(3);
This creates a thread pool with exactly 3 threads. These threads will be reused to execute the
submitted tasks.

Submitting Tasks to the ExecutorService:

executorService.execute(newRunnable("Task 1"));
executorService.execute(newRunnable("Task 2"));
executorService.execute(newRunnable("Task 3"));
Each task is wrapped in a Runnable. In this case, 3 tasks are submitted. Since the thread pool has 3
threads, all tasks can be executed simultaneously.

Shutdown of the ExecutorService:

executorService.shutdown();
This tells the executor to stop accepting new tasks. It will wait for the already submitted tasks to
complete.

Output Example:
The output depends on the order in which the threads get scheduled, but one possible output could be:

pool-1-thread-1: Task 1
pool-1-thread-2: Task 2
pool-1-thread-3: Task 3
Since we have 3 tasks and 3 threads in the pool, each task will run in parallel, and all tasks can
complete almost simultaneously.

What Happens If More Tasks Are Submitted?
If you uncomment the additional tasks (4, 5, and 6):

executorService.execute(newRunnable("Task 4"));
executorService.execute(newRunnable("Task 5"));
executorService.execute(newRunnable("Task 6"));
Since the pool size is 3, the first three tasks will be executed immediately. The remaining
tasks (4, 5, 6) will wait in the queue until a thread becomes available.

Output with All Tasks:
The order of execution for tasks 4, 5, and 6 will depend on when threads become available. For
example:

arduino
Copy code
pool-1-thread-1: Task 1
pool-1-thread-2: Task 2
pool-1-thread-3: Task 3
pool-1-thread-1: Task 4
pool-1-thread-2: Task 5
pool-1-thread-3: Task 6
Each thread is reused to handle multiple tasks, ensuring that threads are not created repeatedly.

Summary:
Tasks are executed by a fixed-size thread pool.
When the number of tasks exceeds the number of threads, remaining tasks are queued.
shutdown() ensures no new tasks are accepted and waits for all submitted tasks to complete.
 */