package org.Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class JavaIFrames {

    WebDriver driver;

    @BeforeTest
    public void beforetest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions Pathao = new ChromeOptions();
        Pathao.addArguments("--remote-allow-origins=*");
        Pathao.addArguments("--disable-geolocation");
        Pathao.setExperimentalOption("useAutomationExtension", false);
        Pathao.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test(priority = 0)
    public void TestCompletion() {
        driver.get("https://demoqa.com/frames");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame1"));
        //There are two ways to find the iframes. one by same itself FrameID when
        // it is given, like in line 40 frame 1 and the another one is by the Xpath.
        // but most probably there will be frameid given like frame1.

        String framecontent = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();
        System.out.println(framecontent);// this code is to find the element in the frame.

        driver.switchTo().defaultContent(); //When we go inside the iframe, then we have
                                            //come outside the iframe also. So, this
                                            //command will help to come out of all the
                                            //frame.

        driver.switchTo().frame("frame2");
        //There are two ways of switching between frames. One by giving the explicit wait
        // like in first code and second by using the switchTo() keyword.

        String framecontent2 = driver.findElement(By.xpath("//h1[@id='sampleHeading']")).getText();

        System.out.println(framecontent2);

        driver.switchTo().defaultContent();

    }

    @Test(enabled = false)
    public void SecondTest() {

        driver.get("https://demoqa.com/nestedframes");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt("frame1"));

        String framecontent = driver.findElement(By.xpath("//body")).getText();

        System.out.println(framecontent);
        //The code above is to go inside the parent frame and find the element inside the
        //parent frame.

        WebElement childframe  = driver.findElement(By.xpath("//iframe[@srcdoc]"));

        driver.switchTo().frame(childframe);
        //The code above is to switch inside the child frame.

        String childframecontent = driver.findElement(By.xpath("//body")).getText();

        System.out.println(childframecontent);
        //The code above is to find the element in the child frame and print it.


        driver.switchTo().defaultContent();//this code is to get out of all the frames.

        driver.switchTo().parentFrame();//This code is to switch from child frame to
                                        //parent frame
        //Should be using one of them at a time between line 90 and line 92.
    }

}
