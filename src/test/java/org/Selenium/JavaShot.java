package org.Selenium;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class JavaShot {

    WebDriver driver;

    @BeforeTest
    public void beforetest() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions Maya = new ChromeOptions();
        Maya.addArguments("--remote-allow-origins=*");
        Maya.addArguments("--start-maximized");
        Maya.setExperimentalOption("useAutomationExtension", false);
        Maya.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void ScreenShot() throws IOException {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("https://www.spicejet.com/");

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String screenshotPath = "C:\\Users\\Yuvraj Tamang\\OneDrive\\Documents\\ScreenShots\\screenshot.png";


        FileUtils.copyFile(screenshot, new File(screenshotPath));
            System.out.println("Screenshot saved to: " + screenshotPath);

        }


    }







