package multithreading.code.threadintro;

public class ThreadExample2 {
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread running");
            System.out.println(Thread.currentThread().getName());
            System.out.println("MyThread finished");
        }
    }

    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        Thread.currentThread().setName("MyThread");
        System.out.println(Thread.currentThread().getName());
        myThread.run();
        //myThread.start();
    }
}
//Output: when myThread.run() is called
        /*
        MyThread
        MyThread running
        MyThread
        MyThread finished
         */
// when myThread.start() is called
/*
MyThread
MyThread running
Thread-0
MyThread finished
 */


    /*
    The output of the ThreadExample2 code will be different from what you might expect from a
    multithreading program. Let's break down why:

        Key Points:
        Thread Naming:
        In the main method, Thread.currentThread().setName("MyThread"); sets the name of the main
        thread (the thread that runs the main method) to "MyThread".
        Calling run() vs start():
        You are calling myThread.run() directly instead of myThread.start().
         When you call run() directly, it does not start a new thread. Instead, it runs the run()
         method in the same thread where run() is called, which in this case is the main thread.
        Expected Output:
        Here’s what happens step by step:

        The main thread is renamed to "MyThread" by the line Thread.currentThread().setName("MyThread");.
        The main thread then calls myThread.run(), which runs the code inside the run() method of
        MyThread but still in the main thread.
        Since Thread.currentThread().getName() is called inside run(), it will print the name of the
        main thread, which is "MyThread".

     */
