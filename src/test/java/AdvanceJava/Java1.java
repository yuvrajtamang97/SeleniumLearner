package AdvanceJava;


import org.testng.annotations.Test;

import java.io.FileNotFoundException;
public class Java1 {

    @Test
    public void trycatch() {
        try {
            System.out.println("TEst1");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("There is InterruptedException");
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("There failed beacuse file is not available");
        }
    }
    //we can have multiple catch in one code, but we can have only one try
    //in catch block we are telling that there is a possibility of this exception to happen and
    //if an exception happens, then what code to print .
    //and we can use finally to give a message to in the end of the code.
    //if you know which exception might come, then add that in the beginning and add the
    //'exception e' exception at the last.
    //try means go through all the code and if any things happens then go to the exception
    //that is catch and check if this exception matches the exception which we have mentioned

}
