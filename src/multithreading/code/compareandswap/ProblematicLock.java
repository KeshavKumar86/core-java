package multithreading.code.compareandswap;

public class ProblematicLock {

    private transient boolean locked = false;

    public void unlock(){
        this.locked = false;
    }
    public void lock(){
        while(this.locked){
            //busy wait - until lock is unlocked
        }
        this.locked = true;
    }
}
