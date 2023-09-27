package org.Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MouseHoverTest {

    WebDriver driver;

    @BeforeTest
    public void beforetest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions Love = new ChromeOptions();
        Love.addArguments("--remote-allow-origins=*");
        Love.setExperimentalOption("useAutomationExtension", false);
        Love.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @Test(enabled = false)
    public void Hover() throws InterruptedException {
        driver.get("https://www.spicejet.com/");
        Actions Good = new Actions(driver);
        WebElement spicejet = driver.findElement(By.xpath("(//div[text()='SpiceClub'])[1]"));
        Good.moveToElement(spicejet).build().perform(); //This is the command which will do the mouse hover
                                                        // or take the mouse to the spice club option.

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(@href,'/home#program')]")));

        WebElement homeprogram = driver.findElement(By.xpath("//a[contains(@href,'/home#program')]"));

        String targetattr = homeprogram.getAttribute("target"); // here they are checking that there is Target Attribute
                                                                      // or not. GetAttribute will look for a specific attribute like
                                                                      // number or anything.
                                                                      // Line 51 till line 62 are related to each other in this class.

        if (targetattr.equals("_blank")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Link Our Program has no attribute _blank");
        }

        homeprogram.click();

        Thread.sleep(4000);

        Good.keyDown(Keys.CONTROL).keyDown(Keys.TAB).build().perform(); // keyboard controls for moving rom one tab to another tab.

    }

    @Test(priority = 0)
    public void open_a_link_in_a_new_tab_test() throws InterruptedException {

        driver.get("https://www.tutorialspoint.com/about/about_careers.htm");
        String term = Keys.chord(Keys.CONTROL, Keys.ENTER);//keyboard action and storing
                                                           //the value in "term" in String
        WebElement element = driver.findElement(By.xpath("//a[text()='Terms of Use']"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",element);
        element.sendKeys(term);
        //then we have to find the element and then send the keys in which you have stored
        //in keys.chord. and then it will open in new tab.
        //Here the javaScript executor is given by me only, just to see how to scroll the
        //page up and down.
        Thread.sleep(1000);

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //In case of multiple window or multiple tab, driver.getWindowHandles
        // have account of every different tabs or windows which are open, and it will handle all
        // the windows or tab which are open in selenium testing.
        // driver.getWindowsHandles is a type of set and this code will convert it into a
        //list
        driver.switchTo().window(tabs.get(1));//0 index will first tab and 1 index will be the
                                              //second tab

        String title = driver.getTitle();

        if (title.equals("Terms of Use")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Landed in wrong tab");
        }

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='search-strings']")));

        driver.findElement(By.xpath("//input[@id='search-strings']")).sendKeys("hhgj");
        //We can also perform different option in that tab also, so the above code is
        //for that only. to perform different actions in that tab.
    }

    @Test(priority = 0)
    public void new_window_test() {
        driver.get("https://demoqa.com/browser-windows");
        String currentwindowid = driver.getWindowHandle();
        //Selenium will give the unique id to every window which will open.
        //the getwindowHandle() which is singular one,
        //this will give the id of current window only.
        //and getwindowHandles() is a plural one
        driver.findElement(By.xpath("//button[@id='windowButton']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        //the above code is making selenium to wait for 2nd windows to open.

        for (String allwindow : driver.getWindowHandles()) {
            if (!currentwindowid.contentEquals(allwindow)) {
                driver.switchTo().window(allwindow);
                break;
            }
        }
        //getWindowHandles will have the id of all the windows that will open
        //For loop will match that if the current window id is not equal to new window id
        //then it is a new window and then it will switch to new window.

        String urlofnewwindow = driver.getCurrentUrl();
        if (urlofnewwindow.contains("https://demoqa.com/sample")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("URL of child window is different");
        }
    }

    @AfterTest(enabled = false)
    public void aftertest() {
        driver.quit();
    }

}

