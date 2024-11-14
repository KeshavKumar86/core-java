package multithreading.code.threadlocalex.practice;

public class InheritableThreadLocalMain {
    public static void main(String[] args) {

        System.out.println("main thread starting");
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        InheritableThreadLocal<String> inheritableThreadLocal = new InheritableThreadLocal<>();

        //create parent thread and child thread and get and set values
        Thread parentThread = new Thread(() -> {
            System.out.println("====Parent thread===");
            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());
            threadLocal.set("thread local value set by parent thread");
            inheritableThreadLocal.set("inheritable thread local value set by parent thread");
            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());

            Thread childThread = new Thread(() -> {
                System.out.println("====Child thread===");
                System.out.println(threadLocal.get());
                System.out.println(inheritableThreadLocal.get());
                threadLocal.set("thread local value set by child thread");
                inheritableThreadLocal.set("inheritable thread local value set by child thread");
                System.out.println(threadLocal.get());
                System.out.println(inheritableThreadLocal.get());

            });
            childThread.start();
        });

        parentThread.start();

        Thread thread2 = new Thread(() -> {
            System.out.println("====Thread2===");

            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());

            threadLocal.set("thread local value set by thread2");
            inheritableThreadLocal.set("inheritable thread local value set by thread2");

            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());

            threadLocal.remove();
            inheritableThreadLocal.remove();

            System.out.println(threadLocal.get());
            System.out.println(inheritableThreadLocal.get());

        });

        thread2.start();
        System.out.println("main thread exiting");
    }
}
