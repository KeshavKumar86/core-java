package multithreading.code.threadintro;

public class ThreadExample5 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        Runnable lambdaRunnable = ()->{
            System.out.println("LambdaRunnanble running");
            System.out.println("LambdaRunnanble  finished");
        };
        Thread lambdaThread = new Thread(lambdaRunnable);
        lambdaThread.start();
        //lambdaThread.run();
        System.out.println(Thread.currentThread().getName());
//        System.out.println("evfiuergfue");
//        System.out.println("evfiuergfue");
//        System.out.println("evfiuergfue");
//        System.out.println("evfiuergfue");
//        System.out.println("evfiuergfue");
//        System.out.println("evfiuergfue");
//        for (int i = 0; i<100000;i++){
//            System.out.println(i);
//        }
    }


}
