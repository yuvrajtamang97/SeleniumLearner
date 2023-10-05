package AdvanceJava;

public class InterfaceExample {
    public static void main(String[] args) {
        Aeroplane Love = new Boeing();

        Aeroplane plane = new Airbus();// we can create only one constructor with the same name.
        //Love is given by me to print both the statement.
        //Previously it was plane only, and we cannot create two constructor with the same name.
        Love.fly();
        plane.fly();

    }
}

interface Aeroplane{
    //void fly();
    default void fly(){
    }
}

class Boeing implements Aeroplane{
    public void fly(){
        System.out.println("Boeing is flying");
    }
}

class Airbus implements Aeroplane{
    public void fly(){
        System.out.println("Airbus is flying");
    }
}
//Example of Abstraction.
//In Interface, all variables are public, static, final by default and the methods are
//public and abstract.
//Interface is a generic or common class.
//In selenium example, webdriver driver = new chromedriver.
//by driver, we can use many things like driver.get or anything else
//same with webdriver too.
//even if we use firefox driver or any other driver, then we have the same methods like driver.get or anthing else.
//Here, Aero Plane is a generic class.