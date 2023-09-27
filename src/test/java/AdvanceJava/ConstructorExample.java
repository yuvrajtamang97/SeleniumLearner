package AdvanceJava;

public class ConstructorExample {
    public static void main(String[] args) {
        Animal animal = new Animal("Tim", 1);
        animal.display();

        Animal animal2 = new Animal("William", 2);//Parametrized Constructor
        animal2.display();

        Animal animal3 = new Animal();//Non Parameterized Constructor
    }
}

class Animal{

    String name;
    int id;

    void display(){
        System.out.println("The name is: "+name);
        System.out.println("The id is: "+id);
    }
    Animal(String hgh, int id){
        name = hgh;
        this.id = id;//"this" keyword is given to remove confusion for selenium
                     //This means instance of the current class.
    }

    Animal(){
        System.out.println("This is empty constructor");
    }
}