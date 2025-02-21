package multithreading.code.executorservice;

import java.util.concurrent.*;

public class ExecutorServiceEx8 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<String> future = executorService.submit(newCallable());
        System.out.println(future.isDone());
        boolean mayInterruptRunning = false;
        System.out.println(future.state());
        boolean isCanceled = future.cancel(mayInterruptRunning);
        System.out.println(isCanceled);

        try {
            String result = future.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        } catch (CancellationException e) {
            String msg = "Cannot call future.get() because task is canceled";
            System.out.println(msg);
        }

        executorService.shutdown();
    }

    private static Callable<String> newCallable() {
        return () -> {
            return Thread.currentThread().getName() + ": " + "Task 1.1";
        };
    }
}
/*
Code Walkthrough and Behavior:
This code demonstrates the use of Future in combination with an ExecutorService. It showcases how to
cancel a task and handle exceptions when calling future.get() on a canceled task.

Code Explanation:
Creating a Thread Pool:
ExecutorService executorService = Executors.newFixedThreadPool(1);
A fixed thread pool with a single thread is created.

Submitting a Callable Task:
Future<String> future = executorService.submit(newCallable("Task 1.1"));
A Callable task is submitted, and it will return a result upon completion.

Checking if Task is Done:
System.out.println(future.isDone());
future.isDone() returns false initially because the task is not yet complete.

Cancelling the Task:
boolean mayInterruptRunning = false;
boolean isCanceled = future.cancel(mayInterruptRunning);
System.out.println(isCanceled);
future.cancel(mayInterruptRunning) cancels the task.
If mayInterruptRunning is true, it tries to interrupt the task if it is currently running.
Since mayInterruptRunning is false, the task will not be interrupted if it is already running.
isCanceled will return true because the task is successfully canceled.


Calling future.get() on a Canceled Task:
try {
    String result = future.get();
    System.out.println(result);
} catch (InterruptedException | ExecutionException e) {
    throw new RuntimeException(e);
} catch (CancellationException e) {
    String msg = "Cannot call future.get() because task is canceled";
    System.out.println(msg);
}
future.get() throws a CancellationException because the task was canceled.
The exception is caught, and the message "Cannot call future.get() because task is canceled" is
printed.

Shutting Down the Executor:
executorService.shutdown();
Gracefully shuts down the executor service after all tasks are completed or canceled.

Expected Output:
future.isDone():

false (The task has not yet completed).
future.cancel(false):

true (The task was successfully canceled).
Cancellation Exception Handling:

"Cannot call future.get() because task is canceled"
Behavior Explanation:
future.cancel(false) cancels the task successfully since it was submitted but not yet executed.
future.get() throws a CancellationException when called on a canceled task, which is caught and
handled by the catch block.
Summary:
This example demonstrates:

How to submit a Callable task using ExecutorService.
How to cancel a task using the cancel() method.
Handling CancellationException when calling get() on a canceled task.
The difference between mayInterruptRunning = true/false.
This code is useful in scenarios where tasks might need to be canceled before completion to save
time or resources.
 */