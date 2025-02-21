package multithreading.code.executorservice;

import java.util.concurrent.*;

public class ExecutorServiceEx4 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<Object> future = executorService.submit(newCallable("Task 1.1"));

        System.out.println(future.isDone());
        try {
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        System.out.println(future.isDone());
        executorService.shutdown();
    }

    private static Callable<Object> newCallable(String msg) {
        return new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return Thread.currentThread().getName() + ": " + msg;
            }
        };
    }
}
/*
Code Walkthrough and Behavior:
This code demonstrates how to use ExecutorService with a Callable task that returns a value.

Code Explanation:
ExecutorService Setup:

ExecutorService executorService = Executors.newSingleThreadExecutor();
Creates a single-threaded executor, meaning only one task will run at a time.
Submitting a Callable Task:

Future future = executorService.submit(newCallable("Task 1.1"));
submit() submits a Callable, which returns a result. The returned Future object can be used to manage
and retrieve the result.
Checking Task Completion:

System.out.println(future.isDone());
This will print false initially because the task may still be running.

Waiting for Task Result:
System.out.println(future.get());
get() blocks until the task completes and retrieves the result returned by the Callable.

Re-checking Task Completion:
System.out.println(future.isDone());
After get(), the task is guaranteed to be complete, so this will print true.

Shutting Down Executor:
executorService.shutdown();
Properly shuts down the executor to release resources.

Expected Output:
false
pool-1-thread-1: Task 1.1
true

First isDone(): false because the task likely hasn’t completed yet.
Callable Output: "pool-1-thread-1: Task 1.1" is printed by retrieving the result of the Callable using
future.get().
Second isDone(): true after the task is completed.
Explanation of Callable:
Callable is similar to Runnable, but it can return a value or throw an exception.
This makes it useful for tasks that need to produce a result after execution.
Use Case:
This approach is ideal when you need to submit tasks that return results.
For example, it’s useful in scenarios where you want to:
Perform computations in parallel and collect results.
Fetch data from different sources in separate threads and then use the result.
This example illustrates how to combine asynchronous task execution with result retrieval using
Callable and Future.
 */