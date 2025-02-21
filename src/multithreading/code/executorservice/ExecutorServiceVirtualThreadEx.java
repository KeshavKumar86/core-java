package multithreading.code.executorservice;

import java.util.concurrent.*;

public class ExecutorServiceVirtualThreadEx {
    public static void main(String[] args) {
        //ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Object> future = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                return Thread.currentThread().getName() + ": " + "Task 1.1";
            }
        });
        Callable<String> callable = ()->{
            System.out.println("Callable executed by virtual thread");
            return "Result from Callable";
        };

        Future<String> future2 = executorService.submit(callable);
        try {
            System.out.println(future.get());
            System.out.println(future2.get());
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
/*
Code Walkthrough: Virtual Threads with ExecutorService
This code demonstrates the use of virtual threads introduced in JDK 19+. Virtual threads are
lightweight, enabling the concurrent execution of a large number of tasks without the overhead of
traditional platform threads.

Code Explanation
Creating a Virtual Thread Executor:
ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor();
newVirtualThreadPerTaskExecutor() creates an executor that assigns one virtual thread per task.
Virtual threads are much lighter than platform threads, allowing thousands of tasks to run efficiently.

Submitting Tasks to Virtual Threads:
Future<Object> future = executorService.submit(new Callable<Object>() {
    @Override
    public Object call() throws Exception {
        return Thread.currentThread().getName() + ": " + "Task 1.1";
    }
});
The first Callable task prints the name of the virtual thread executing it and returns the result.


Callable<String> callable = () -> {
    System.out.println("Callable executed by virtual thread");
    return "Result from Callable";
};

Future<String> future2 = executorService.submit(callable);
The second Callable prints a message and returns a string as a result.

Retrieving Results Using Future:
try {
    System.out.println(future.get());
    System.out.println(future2.get());
} catch (InterruptedException | ExecutionException e) {
    throw new RuntimeException(e);
}
future.get() waits for the task to complete and prints the result.
If the task encounters an exception, ExecutionException will be thrown.

Expected Output
The output will be something like:\
Callable executed by virtual thread
VirtualThread-1: Task 1.1
Result from Callable
The first task prints the virtual thread name and the message "Task 1.1".
The second task prints "Callable executed by virtual thread" and returns the message "Result from Callable".
Key Concepts
Virtual Threads:
Virtual threads are user-mode threads that don't map directly to platform threads. They are managed by
the JVM, making it possible to spawn a large number of threads without significant performance costs.

Virtual Thread Executor:

Each task gets its own virtual thread.
Virtual threads enhance concurrency in I/O-bound or high-volume tasks without the complexities of
platform thread management.
ExecutorService with Virtual Threads:
This approach allows you to seamlessly manage many concurrent tasks, making virtual threads ideal for
I/O-heavy or microservices-based applications.

Summary
This example showcases:

How to use virtual threads with ExecutorService.
Submitting Callable tasks and retrieving results using Future.
Virtual threads' ability to handle concurrent tasks efficiently.
This code demonstrates the power and simplicity of virtual threads and why they are a game-changer for
modern concurrent programming in Java.
 */