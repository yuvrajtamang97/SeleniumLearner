package AdvanceJava;

public class AbstractionUsingAbstractClass {

    public static void main(String[] args) {
        Bungur myBungur = new Bungur(); // Creating a Bungur object
        myBungur.animalSound();
        myBungur.sleep();
    }
}

// Abstract class
abstract class Janawar {
    // Abstract method (does not have a body)
    public abstract void animalSound();
    // Regular method
    public void sleep() {
        System.out.println("Zzz");
    }
}

// Subclass (inherit from Animal)
class Bungur extends Janawar {
    public void animalSound() {
        // The body of animalSound() is provided here
        System.out.println("Bungur says: wee wee");
    }
}

//We can only extend one class here in abstraction.
//Java does not allow to extend more than one class is abstraction.
//If we want to implement more than one class in abstraction, then go for the
//Interface class.
//Abstract class have both abstract and non-abstract method.