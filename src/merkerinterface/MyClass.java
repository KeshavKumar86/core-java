package merkerinterface;

public class MyClass implements SpecialType{
    private final String name;
    public MyClass(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
}
