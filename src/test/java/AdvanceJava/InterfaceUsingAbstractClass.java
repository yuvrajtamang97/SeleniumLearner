package AdvanceJava;

public class InterfaceUsingAbstractClass {

    public static void main(String[] args) {
        //Aeroplane plane = new Boeing();

        Aeroplane plane = new Airbus();

        plane.fly();
        plane.landing();
    }
}

//interface Aeroplane{
//    void fly();
//}

abstract class Aeroplanes{
    abstract void fly();

    void landing(){
        System.out.println("Aeroplane is landing");
    }
}

class Boeings extends Aeroplanes{
    public void fly(){
        System.out.println("Boeing is flying");
    }
}

class Airbuss extends Aeroplanes{
    public void fly(){
        System.out.println("Airbus is flying");
    }
}
