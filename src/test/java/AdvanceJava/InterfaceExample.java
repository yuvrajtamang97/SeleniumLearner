package AdvanceJava;

public class InterfaceExample {
    public static void main(String[] args) {
        //Aeroplane plane = new Boeing();

        Aeroplane plane = new Airbus();

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
//even if we use firefox driver, then we have the same methods like driver.get or anthing else.
//Here Aeroplane is a generic class.