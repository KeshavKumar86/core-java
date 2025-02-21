package multithreading.code.executorservice;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceEx7 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        executorService.shutdown();

        List<Runnable> runnables = executorService.shutdownNow();
        try {
            executorService.awaitTermination(3000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
/*
Code Walkthrough and Behavior:
This code demonstrates shutdown methods of ExecutorService, including the difference between
shutdown() and shutdownNow(). Let's go over the behavior and purpose of each call step-by-step.

Code Explanation:
Creating a Thread Pool:
ExecutorService executorService = Executors.newFixedThreadPool(3);
A thread pool with 3 threads is created.

Shutting Down the Executor:
executorService.shutdown();
shutdown():
Initiates a graceful shutdown where no new tasks are accepted.
Already submitted tasks will continue to run until completion.

Calling shutdownNow():
List<Runnable> runnables = executorService.shutdownNow();
shutdownNow():
Attempts to stop all running tasks and returns a list of tasks that were waiting in the queue but not
yet executed.
Running tasks may or may not stop, depending on how they handle interruption.
In this case, since the executor is already shut down using shutdown(), the task queue would
likely be empty. Thus, the returned list may be empty.


Awaiting Termination:
executorService.awaitTermination(3000, TimeUnit.MILLISECONDS);
awaitTermination() waits for the thread pool to shut down completely for the specified time
(3 seconds here).
If the executor does not shut down within the specified time, it returns false; otherwise, it
returns true if the shutdown completes within the time limit.

Exception Handling:
catch (InterruptedException e) {
    e.printStackTrace();
}
InterruptedException may occur if the current thread is interrupted while waiting for the termination
of the executor service.
Expected Output:
This program won't produce any console output since:

No tasks are submitted to the executor.
The list from shutdownNow() will likely be empty because the thread pool had no queued tasks.
Behavior Explanation:
shutdown() vs. shutdownNow():

shutdown() allows already submitted tasks to complete.
shutdownNow() tries to cancel running tasks and returns the unexecuted tasks in a list.


Use Case:
This code demonstrates the lifecycle of thread pools:
Graceful shutdown (shutdown)
Immediate shutdown (shutdownNow)
Waiting for termination (awaitTermination)
Edge Case:
If shutdownNow() is called after shutdown(), the list of pending tasks will be empty, since the
executor was already instructed to reject new tasks.

Summary:
This code demonstrates how to cleanly shut down an ExecutorService. In real-world scenarios:

shutdown() is typically preferred when you want the current tasks to finish.
shutdownNow() can be used when you need to immediately interrupt all tasks
(though interruption behavior depends on the tasks).
awaitTermination() is used to wait for the shutdown process to complete.
 */