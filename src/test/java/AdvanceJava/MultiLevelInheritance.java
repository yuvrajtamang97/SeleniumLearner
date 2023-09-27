package AdvanceJava;

public class MultiLevelInheritance {

    public static void main(String[] args) {
        Color color = new Color();
        color.wing();
        color.color();
        color.shade();
    }
}

class Birds{
    void wing(){
        System.out.println("Have 2 wings");
    }
}//Birds will have access to wing only

class Parrots extends Birds{

    void color(){
        System.out.println("have green color");
    }
}//Parrots will have access to wing and color both

class Color extends Parrots {
    void shade() {
        System.out.println("shade name is light green ");
    }
}//and Color will have access to everything i.e. wing, color and shade.

