package org.Selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class ClassTest {

    WebDriver driver;

    @BeforeTest
    public void beforetest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--start-maximized");
        ops.addArguments("--incognito");
        ops.addArguments("--disable-geolocation");
        ops.setExperimentalOption("useAutomationExtension", false);
        ops.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver(ops);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);

    }

    @Test(enabled = false)
    public void test_select_class() {
        driver.get("https://demoqa.com/select-menu");

        WebElement selectcolor = driver.findElement(By.xpath("//select[@id='oldSelectMenu']"));

        Select se = new Select(selectcolor);

        se.selectByIndex(1);
            /*se.selectByVisibleText("Purple");
            se.selectByValue("Red");

            se.deselectAll();*/
    }

    /*@Test
    public void test_alerts() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.xpath("//button[@id='confirmButton']")).click();

        Thread.sleep(2000);
        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().dismiss();
        driver.switchTo().alert().accept();


        Thread.sleep(2000);
    }*/

    @Test
    public void alerts() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");

        Thread.sleep(3000);

        WebElement element = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
        Thread.sleep(1000);
        element.click();
        Thread.sleep(1000);
        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().dismiss();
        //driver.switchTo().alert().accept();
        //We have to do either one of them, either dismiss or accept.

        Thread.sleep(1000);
        //For every JavaScript Executor for scroll down, First we have to find web element
        //through find element, and then we have to scroll to the element through javascript
        //executor and then we have to perform the action click or send keys.


        String var = driver.findElement(By.xpath("//span[@id='confirmResult']")).getText();
        System.out.println(var);
        if (var.contains("Cancel")) {
            Assert.assertTrue(true);

        } else {
            Assert.fail("Cancel message not present after dismissing");
        }

    }

        @AfterTest
        public void aftertest () {

            driver.quit();
        }


    }

