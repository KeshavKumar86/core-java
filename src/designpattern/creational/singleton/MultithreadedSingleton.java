package designpattern.creational.singleton;

public class MultithreadedSingleton {
    private static MultithreadedSingleton instance;

    private MultithreadedSingleton(){

    }
    //synchronized method
//    private static synchronized MultithreadedSingleton getInstance(){
//        if(instance==null){
//            instance = new MultithreadedSingleton();
//        }
//        return instance;
//    }

    //using synchronized block
    private static  MultithreadedSingleton getInstance(){
        if(instance==null){
            synchronized (MultithreadedSingleton.class){
                if(instance == null){
                    instance = new MultithreadedSingleton();
                }

            }
        }
        return instance;
    }
}
