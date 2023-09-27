package AdvanceJava;

public class InheritanceExample {

    public static void main(String[] args) {
        Parrot parrot = new Parrot();
        parrot.wing();
        parrot.color();

    }
}

class Bird{
    void wing(){
        System.out.println("Have 2 wings");
    }
}

class Parrot extends Bird{

    void color(){
        System.out.println("have green color");
    }
}
//Single level Inheritance
//We cannot inherit when the class is Final And the Private class.
//Parrot extends bird
//child extends parent
