package multithreading.code.threadintro;

public class ThreadExample3 {
    public static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("My Runnable Running");
            Thread.currentThread().setName("Thread implementation using Runnable interface");
            System.out.println(Thread.currentThread().getName());
            System.out.println("My Runnable finished");
        }
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable());
        System.out.println(Thread.currentThread().getName());
        //thread.run();
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }
}
