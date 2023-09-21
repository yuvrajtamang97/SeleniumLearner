package org.Selenium;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestNGp {

    @BeforeTest
    public void beforetest(){
        System.out.println("beforetest");
    }

    @BeforeMethod
    public void beforemethod(){
        System.out.println("beforemethod");
    }


    @Test
    public void test1(){
        System.out.println("test1");
    }

    @AfterMethod
    public void aftermethod(){
        System.out.println("aftermethod");
    }



    @Test
    public void test2(){
        System.out.println("test2");
    }



    @AfterTest
    public void aftertest(){
        System.out.println("aftertest");
    }
}
