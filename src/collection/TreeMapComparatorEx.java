package collection;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeMap;

public class TreeMapComparatorEx {

    public static void main(String[] args) {
        //create treemap
        TreeMap<Employee,String> treemap = new TreeMap<>();
        treemap.put(new Employee("5","Keshav"),"Employee5");
        treemap.put(new Employee("2","Lalit"),"Employee2");
        treemap.put(new Employee("3","Ritesh"),"Employee3");
        treemap.put(new Employee("6","Ankur"),"Employee6");
        treemap.put(new Employee("4","Yadav"),"Employee4");

        System.out.println(treemap);

        TreeMap<Employee,String> treemapc = new TreeMap<>(new NameCompare());
        treemapc.put(new Employee("5","Keshav"),"Employee5");
        treemapc.put(new Employee("2","Lalit"),"Employee2");
        treemapc.put(new Employee("3","Ritesh"),"Employee3");
        treemapc.put(new Employee("6","Ankur"),"Employee6");
        treemapc.put(new Employee("4","Yadav"),"Employee4");
        System.out.println(treemapc);
    }

}
class Employee implements Comparable<Employee>{

    String id;
    String name;

    public Employee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int compareTo(Employee e){
      return this.id.compareTo(e.id);
  }
}

class NameCompare implements Comparator<Employee>{

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.name.compareTo(o2.name);
    }
}