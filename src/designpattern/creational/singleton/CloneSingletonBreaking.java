package designpattern.creational.singleton;

public class CloneSingletonBreaking implements Cloneable{
    private static final CloneSingletonBreaking instance = new CloneSingletonBreaking();

    private CloneSingletonBreaking(){

    }
    public static CloneSingletonBreaking getInstance(){
        return instance;
    }

    @Override
    public CloneSingletonBreaking clone() {
        try {
            return (CloneSingletonBreaking) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
