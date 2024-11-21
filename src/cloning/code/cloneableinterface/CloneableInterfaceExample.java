package cloning.code.cloneableinterface;

public class CloneableInterfaceExample {
    public static void main(String[] args) {

        Employee employee = new Employee("Keshav",25,"Mindtree");
        System.out.println("Original Employee: " + employee);
        //clone this object
        Employee clone = employee.clone();
        System.out.println("Cloned Employee: " + clone);

    }
}
