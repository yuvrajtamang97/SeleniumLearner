package org.Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class SeleniumUITest {


    WebDriver driver;

    @BeforeTest
    public void beforetest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--start-maximized");
        ops.addArguments("--incognito");
        ops.setExperimentalOption("useAutomationExtension", false);
        ops.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver(ops);
        //TimeUnit.SECONDS.sleep(5);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);


    }

    @Test(enabled = false)
    public void firsttest() {
        driver.get("https://www.saucedemo.com/");

        String title = driver.getCurrentUrl();

        if (title.equals("Swag Labs")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Title didn't match");
        }
    }

    @Test( priority = 0)
            public void uitest() {
        driver.get("https://www.saucedemo.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id='password']")));
        element.sendKeys("standard_user");

        //driver.findElement(By.cssSelector("input[id='user-name']")).sendKeys("locked_out_user");
        /*driver.findElement(By.cssSelector("input[id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("input[id='login-button']")).click();

        String errortext = driver.findElement(By.xpath("//div[contains(@class,'error-message-container error')]")).getText();
         if (errortext.contains("Sorry, this user has been locked out")) {
             Assert.assertTrue(true);
         } else {
             Assert.fail("Text does not contains Locked out user");
         }*/
    }

    @Test( enabled = false)
    public void Advance() {
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.xpath("input[@id='user-name']")).sendKeys("locked_out_user");
        driver.findElement(By.xpath("input[@id='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("input[@id='login-button']")).click();

    }

    @AfterTest
    public void aftertest() {

        driver.quit();
    }
}
