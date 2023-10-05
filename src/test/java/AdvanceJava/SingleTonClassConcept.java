package AdvanceJava;

public class SingleTonClassConcept {

    public static void main(String[] args) {
        String a = "apple";
        String b = "apple";
        String c = new String("apple");

        System.out.println(a.equals(c));//It checks equality in the string level
                                        // it checks whether they are alphabetically equal or not.
        System.out.println(a == c);//it checks whether they are from the same memory location or not.
        //String has two location. when you directly assign a and b = "apple", then java keeps them in
        //a same memory location.
        //And whenever we use a "new" keyword then java assigns it's a new memory
        //location even if they are same alphabetically.
        //So, therefore a.equals b and a == b is true because they are same alphabetically
        //and stored in same memory location also.
        //And, a.equals c is true and a == c is false, because they are same alphabetically
        // but, they are not in same memory location.
        // So, therefore to overcome this problem, we have to use the singleton class concept.
        System.out.println(a.hashCode());//These hashcode are given to just print the id of 'a'.
        System.out.println(b.hashCode());
        System.out.println(Integer.toHexString(System.identityHashCode(a)));
        System.out.println(Integer.toHexString(System.identityHashCode(c)));

        Singleton x = Singleton.getInstance();
        Singleton y = Singleton.getInstance();

        System.out.println("Single class: ");
        System.out.println(x==y);
        Singleton.getInstance().display();

    }
}

class Singleton{
    private static Singleton single_instance = null;//Static provides a single memory location.
    //We have to initialize it null.
    private Singleton() {}

    //These two we have to create them private.

    public static Singleton getInstance(){
        if (single_instance == null){
            single_instance = new Singleton();
        }

        return single_instance;
    }

    public void display(){

        System.out.println("Dummy method");
    }
}

//this format of singleton class is same.