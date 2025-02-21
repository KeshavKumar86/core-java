package multithreading.code.executorservice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceEx6 {
    public static void main(String[] args) {

        List<Callable<String>> callables = new ArrayList<>();

        callables.add(newCallable("Task 1.1"));
        callables.add(newCallable("Task 1.2"));
        callables.add(newCallable("Task 1.3"));

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            List<Future<String>> results = executorService.invokeAll(callables);
            for(Future<String> future : results){
                System.out.println(future.isDone());
                System.out.println(future.get());
                System.out.println(future.isDone());
            }
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
        executorService.shutdown();
    }

    private static Callable<String> newCallable(String msg) {
        return new Callable<String>() {
            @Override
            public String call() throws Exception {
                return Thread.currentThread().getName() + ": " + msg;
            }
        };
    }
}
/*
Code Walkthrough and Behavior:
This code demonstrates using invokeAll() with ExecutorService to execute multiple Callable tasks in
parallel and collect their results.

Key Concept:
invokeAll(List<Callable<T>> tasks):
Executes all the provided tasks and returns a list of Future<T> objects.
Each Future represents the result of a specific task.
This method blocks until all tasks are completed.
If one task fails, the exception is captured inside the corresponding Future.


Code Explanation:
Creating Callables:
List<Callable<String>> callables = new ArrayList<>();
callables.add(newCallable("Task 1.1"));
callables.add(newCallable("Task 1.2"));
callables.add(newCallable("Task 1.3"));
Three Callable tasks are created, each returning a string message that includes the current thread’s
name.


Setting up ExecutorService:
ExecutorService executorService = Executors.newSingleThreadExecutor();
A single-threaded executor is used, meaning only one task will run at a time.

Invoking All Tasks:
List<Future<String>> results = executorService.invokeAll(callables);
invokeAll() runs all the tasks and returns a list of Future objects, one for each task.

Processing the Results:
for (Future<String> future : results) {
    System.out.println(future.isDone());  // Check if task is done
    System.out.println(future.get());     // Retrieve the result
    System.out.println(future.isDone());  // Confirm task is done
}
For each task, it:
Checks if the task is done with isDone().
Retrieves the result using get().
Confirms again that the task is done.

Shutting Down the ExecutorService:
executorService.shutdown();
This ensures the executor service stops after completing the tasks.
Expected Output:
Since only one thread is available (from the single-thread executor), the tasks will run sequentially
in the order they are submitted.

true
pool-1-thread-1: Task 1.1
true
true
pool-1-thread-1: Task 1.2
true
true
pool-1-thread-1: Task 1.3
true
Explanation of Execution:
The tasks are executed one by one because the executor uses a single thread.
For each task, the following happens:
future.isDone() returns true after the task completes.
future.get() returns the result: "pool-1-thread-1: Task X".
All tasks run on the same thread (pool-1-thread-1) because of the single-threaded executor.


Summary:
invokeAll() ensures all tasks are executed and their results are collected.
Since a single-thread executor is used, tasks are executed one at a time in sequence.
The isDone() check ensures that the task has completed, and get() blocks until the result is available.
This pattern is useful when you need to execute multiple tasks and wait for all of them to complete,
especially when the results of all tasks are required.
 */