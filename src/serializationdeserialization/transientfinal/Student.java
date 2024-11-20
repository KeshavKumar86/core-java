package serializationdeserialization.transientfinal;

import java.io.Serializable;

public class Student implements Serializable {
     private transient final String name;
    private transient final String surName = "Singh";
    private transient int id = 34;

    Student(String name, /*String surName,*/ int id){
        this.name = name;
        this.id = id;
        //this.surName = surName; this will give error because once initialized we cannot change
        //the value of final variable
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", surName='" + surName + '\'' +
                ", id=" + id +
                '}';
    }
}
/*
Normal transient field (without final):

private transient int id = 34;
When the object is serialized, this field is skipped (because it’s transient).
During deserialization, since Java doesn't call the constructor and doesn't save the field value, the
field will reset to its default value (in this case, 0 for int).
Expected value after deserialization:

id = 0
Transient final field:

private transient final String surName = "Singh";
The difference with surName is that it is both final and transient.
Final fields are treated specially by the JVM: When an object is reconstructed, Java retains the
value declared at the field level. This is because final fields are inlined into the class’s bytecode,
and the JVM ensures that they are reinitialized with their original values during deserialization.
Why Your transient int id = 34; Won’t Retain 34 After Deserialization
When a field is not final, it is just reset to its default value during deserialization
(e.g., 0 for int).
Since id is transient but not final, its value (34) is not saved, and there is no guarantee for it
to be restored during deserialization.
Key Rule
Transient + Final Fields:
Retain their initialized value (like "Singh") after deserialization, even though they are transient.

Transient Fields (Without Final):
Are reset to default values (e.g., 0 for int, null for objects) during deserialization, since they
aren't part of the serialized state.

Example to Test Behavior

import java.io.Serializable;

public class TestClass implements Serializable {
    private transient int id = 34;
    private transient final String surName = "Singh";

    @Override
    public String toString() {
        return "TestClass{id=" + id + ", surName='" + surName + "'}";
    }
}
Expected Output After Deserialization:

bash
Copy code
TestClass{id=0, surName='Singh'}
Summary
id (transient, not final): Reset to 0 after deserialization.
surName (transient final): Retains "Singh" because final fields are reinitialized from their declaration.
This behavior highlights how final fields are treated differently during deserialization, ensuring that their initial values are retained.
 */

/*
GFG
Transient Vs Final:
final variables will be participated into serialization directly by their values.
Hence declaring a final variable as transient there is no use.
//the compiler assign the value to final variable


example:

final int x= 10;
int y = 20;
System.out.println(x);// compiler will replace this as System.out.println(10)->10
because x is final.
System.out.println(y);//20
 */