import java.sql.Array;

public class OOPS {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.setColor("Blue");
        System.out.println(p1.color);

        // Access Modifier
        //   public -- anywhere
        //   private -- only within class
        //   protrcted -- within class, package and outside pakage using sub-classes
        //   default   -- within class and package

        //Package -- group of similar types of classes, interfaces ad subpackages

        //Java does not support multiple inheritance directly with classes.
        //Java's Solution:
        //Java provides interfaces to achieve a form of multiple inheritance. A class can implement multiple interfaces, allowing it to inherit method signatures from different sources.



    }
}
    class Pen {
        String color;
        int tip;

        // Setter
        void setColor(String newcolor) {
            this.color = newcolor;
        }

        // Getter

        public String getColor() {
            return color;
        }

        void setTip(int newtip) {
            tip = newtip;
        }

    }
    class Student {
        String name;
        int age;
        float percentage;
        int[] marks = new int[3];

        // Constructor
        Student (String name) {
            this.name = name;
            System.out.println("Constructor called");
        }

        //Types of Constructor
           // Non-parameterized
           // Parameterized
           // Copy Constructor -- make copy of all elements of a object to another
           Student(Student s1) {
            this.name = s1.name;
            this.age = s1.age;
            this.marks = s1.marks;  // Refering to the same adderess so values of arr s1 and s2 are same.
               // if you want to change it use loop (deep copy).

           }

           // Lazy Copy combination of both - initially shallow , maintain a counter and deep copy if necessary

           // Destructor -- for dealocation, in java we have garbage collector so...

        void calculatepercentage(int phy,
         int chem, int Math) {
            percentage = (phy + chem + Math)/3;
        }
    }

    /*
    ABSTRACT Class
    * cannot create an instance/object of abstract class
    * can have abstract/non-abstract methods
    * can have constructors
    * */
    abstract class Animal {
        void eat() {
            System.out.println("animal eats");
        }
        abstract void walk();  //compulsory for all subclass
    }
    class horse extends Animal {
    void walk() {
        System.out.println("walks on four legs");
    }
    }

    // INTERFACES -- blueprint of a class
        // multiple inheritance ( which cant be implemented using classes)
        // Total Abstraction
        // Used via implements keyword
        // All methods are public, abstract & without implementation
        // Used to achieve total abstraction
        // Variables in the interfaces are final, public and static

    // Static Keyword - used to share the same variable or method of a given class

    // Super Keyword - used to refer immediate parent class object.
        // to access parents properties
        // to access parents functions
        // to access parents constructor -- super();
                // Java by-default calls super(); -- so parents constructor called when child created.

    //

// Class cant be "Private" & "Protected" -- making that that class cant be used further. it is unusable so you cant do it in java.
    // But you can make "Nested-class","Constructor","Method" and "Field" as a private and protected.

// Vehicle v = new Car();
// (Parent)    (child)      // ALLOWED

