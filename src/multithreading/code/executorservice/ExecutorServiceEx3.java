package multithreading.code.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceEx3 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<?> future = executorService.submit(newRunnable("Task 1.1"));

        System.out.println(future.isDone());

        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(future.isDone());
        executorService.shutdown();
    }

    private static Runnable newRunnable(String msg) {
        return new Runnable(){
            @Override
            public void run() {
                String completeMsg = Thread.currentThread().getName() + ": " + msg;
                System.out.println(completeMsg);
            }
        };
    }
}
/*
Code Walkthrough and Behavior:
This code demonstrates how to use ExecutorService with a Future to submit a task and check its
completion status.

Code Explanation:
ExecutorService Setup:

ExecutorService executorService = Executors.newSingleThreadExecutor();
A single-threaded executor is created. This ensures that only one task runs at any given time.
Submitting a Task:

Future future = executorService.submit(newRunnable("Task 1.1"));
submit() is used to submit the task, returning a Future object. This does not block the calling thread
but allows you to monitor and manage the task.
Checking if Task is Done:

System.out.println(future.isDone());
isDone() will print false initially because the task is likely still running or hasn't completed yet.
Waiting for Task to Complete:

future.get();
get() waits (blocks) until the task completes. If the task is interrupted or throws an exception,
the ExecutionException or InterruptedException will be thrown.

Checking if Task is Done After Completion:
System.out.println(future.isDone());
After future.get() completes, the second isDone() call will print true.

Shutting Down the Executor:
executorService.shutdown();
Always shut down the executor to release resources properly.
Expected Output:
The output will look something like this:
false
pool-1-thread-1: Task 1.1
true

First isDone(): false because the task hasn't completed when the check occurs.
Task Execution Output: Prints "pool-1-thread-1: Task 1.1" when the task completes.
Second isDone(): true because future.get() ensures the task has finished.

Key Points and Use Case:
Single-threaded Executor:
Ensures tasks run sequentially.
Useful when you want strict order of execution.

Future Usage:
Lets you check task status (isDone()) and wait for completion with get().
get() is blocking, meaning the current thread will pause until the task completes.

Error Handling:
If the task throws an exception, it will be wrapped inside an ExecutionException, which needs to be
caught.
This approach is useful when you need to asynchronously run tasks but still want to monitor their
completion or get the results when available.
 */