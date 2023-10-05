package AdvanceJava;

public class GenericsClass {

    static <T> void display(T element){
        System.out.println(element);
    }

    public static void main(String[] args) {
        Test<String> a = new Test<>("abc");
        System.out.println(a.getObj());//Generic class i.e. "<>" ensures that you are passing the data type and the value.
        //But it is not necessary to pass the values in the curly bracket "()"
        //in hashset and hashmap.
        //Generic class is used when we don't know what kind of data might come.
        display("Test");
        display(14);
    }

}

class Test<T> { // we have to use "<>" this bracket in generic class.
    T obj;

    Test(T obj){
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }
}