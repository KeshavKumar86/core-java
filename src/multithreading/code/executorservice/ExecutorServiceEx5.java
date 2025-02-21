package multithreading.code.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceEx5 {
    public static void main(String[] args) {
        List<Callable<String>> callables = new ArrayList<>();
        callables.add(newCallable1());
        callables.add(newCallable());
        callables.add(newCallable());

        //ExecutorService executorService = Executors.newSingleThreadExecutor();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        try {
            String result = executorService.invokeAny(callables);
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }

    private static Callable<String> newCallable() {
        return () -> Thread.currentThread().getName() + ": " + "Task 1.1";
    }

    private static Callable<String> newCallable1() {
        return new Callable() {
            @Override
            public Object call() throws Exception {
                sleep();
                return Thread.currentThread().getName() + ": " + "Task 1.1";
            }

            private void sleep() {
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}
/*
Code Walkthrough and Behavior:
This code demonstrates using ExecutorService with invokeAny() to submit multiple Callable tasks,
where only the first successfully completed task's result is returned.

How invokeAny() Works:
invokeAny(List<Callable<T>> tasks):
Submits a collection of tasks to an ExecutorService.
Only one of the tasks’ results is returned—the first one to complete successfully.
If one task finishes, the others are canceled.
Code Explanation:
Callable Task List Creation:
List<Callable<String>> callables = new ArrayList<>();
callables.add(newCallable1("Task 1.1")); // This sleeps for 8 seconds.
callables.add(newCallable("Task 1.1"));
callables.add(newCallable("Task 1.1"));
The first task (newCallable1) sleeps for 8 seconds, while the other two tasks don't sleep.

ExecutorService Setup:
ExecutorService executorService = Executors.newSingleThreadExecutor();
A single-threaded executor is used, meaning only one task can run at a time.

Using invokeAny() to Execute Callables:
String result = executorService.invokeAny(callables);
System.out.println(result);
invokeAny() runs the tasks sequentially (because only one thread is available).
It returns the first completed result.
Handling Exceptions and Shutdown:
try {
    String result = executorService.invokeAny(callables);
    System.out.println(result);
} catch (InterruptedException | ExecutionException e) {
    throw new RuntimeException(e);
}

executorService.shutdown();
If a task throws an exception, invokeAny() will propagate it as an ExecutionException.

Expected Output:
Since we are using a single-threaded executor, only one task will execute at any given time.
The second and third tasks (created using newCallable()) don’t sleep, so one of them will finish first.

pool-1-thread-1: Task 1.1
Explanation of Execution:
With a single-threaded executor, the tasks are run one by one.
First Task (newCallable1) sleeps for 8 seconds, so it won't be the one returning a result first.
The second or third task (both created with newCallable()) will finish first, and their result will
be returned immediately by invokeAny().
Summary:
Only one of the tasks' results will be printed, specifically the first one that completes.
Even though newCallable1 is slower due to Thread.sleep(8000), it doesn’t affect the outcome because
invokeAny() stops waiting as soon as one task finishes successfully.
 */