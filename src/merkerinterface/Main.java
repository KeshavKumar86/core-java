package merkerinterface;

public class Main {
    public static void main(String[] args) {
        MyClass obj = new MyClass("MarkerTest");
        if (obj instanceof SpecialType) {
            System.out.println(obj.getName() + " is marked as SpecialType");
        } else {
            System.out.println(obj.getName() + " is not marked as SpecialType");
        }

    }
}
