package AdvanceJava;

//Example Of Method Overriding
public class ProtectedInheritedClass {

    public static void main(String[] args) {
        Colorss color = new Colorss();
        color.wing();
        color.color();
        color.shade();
    }
}

class Birdss{
    protected void wing(){
        System.out.println("Have 2 wings");
    }
}//Protected means it is not accessible to other class, but it is accessible to the class
// which is extending it or inheriting it.

class Parrotss extends Birdss{

    void color(){
        System.out.println("have green color");
    }
}

class Colorss extends Parrotss {

    void color(){
        super.color();
        System.out.println("have green color from color class");
    }//here super means the parent. super is used to access the value of parent class
     //Super means instance of the previous class.

    void shade() {
        System.out.println("shade name is light green ");
    }
}
