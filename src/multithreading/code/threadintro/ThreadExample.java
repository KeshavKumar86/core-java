package multithreading.code.threadintro;

public class ThreadExample {
    public static void main(String[] args) {
        Thread thread = new Thread("myThread");
        System.out.println(Thread.currentThread().getName());
        thread.start();
        System.out.println(Thread.currentThread().getName());
    }

}
