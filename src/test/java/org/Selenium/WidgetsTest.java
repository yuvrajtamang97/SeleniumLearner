package org.Selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class WidgetsTest {

    WebDriver driver;

    @BeforeTest
    public void beforetest() {
        WebDriverManager.chromedriver().setup();
        String downloadFilepath = "C:\\Users\\Yuvraj Tamang\\OneDrive\\Desktop\\Selenium First\\SeleniumLearner\\Downloads";
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadFilepath);
        //Hashmap and the other codes including the chrome preferences are related to file
        //download in selenium.
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--remote-allow-origins=*");
        ops.addArguments("--incognito");
        ops.setExperimentalOption("prefs", chromePrefs);
        ops.setExperimentalOption("useAutomationExtension", false);
        ops.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @Test(enabled = false)
    public void test_download() throws InterruptedException {
        driver.get("https://demoqa.com/upload-download");

        WebElement button = driver.findElement(By.xpath("//a[@id='downloadButton']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(button));

        button.click();

        Thread.sleep(5000);

    }

    @Test(enabled = false)
    public void test_file_upload() {
        driver.get("https://demoqa.com/upload-download");
        driver.findElement(By.xpath("//input[@id='uploadFile']")).sendKeys("C:\\Users\\Yuvraj Tamang\\OneDrive\\Desktop\\Selenium First\\SeleniumLearner\\Downloads\\sampleFile.jpeg");
        String uploadtext = driver.findElement(By.xpath("//p[@id='uploadedFilePath']")).getText();
        //We can only some files. Not everything ids possible
        //if the choose file starts with input, so we can test it using selenium otherwise
        //we can not test using selenium.
        if (uploadtext.contains("sampleFile.jpeg")) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("File not uploaded!!");
        }
    }

    @Test(enabled = false)
    public void test_autocomplete() throws InterruptedException {
        driver.get("https://jqueryui.com/autocomplete/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='tags']")).sendKeys("C");
        //first we have to send a character.

        String texttobeclicked = "Clojure";// expected things to be clicked.
        WebElement autooptions  = driver.findElement(By.id("ui-id-1"));

        try {
            wait.until(ExpectedConditions.visibilityOf(autooptions));
        } catch (TimeoutException e) {
            System.out.println("No element present with the character");
        }
        //we have to wait until the above element come in auto complete box.

        List<WebElement> alloptions = autooptions.findElements(By.tagName("li"));


        for (WebElement option : alloptions) {
            if (option.getText().equals(texttobeclicked)) {
                option.click();
                break;
            }
        }
        //All the options which will be coming are stored in a tagname li so that's
        //why we are doing the above code.


        Thread.sleep(3000);

    }

    @Test(priority = 0)
    public void test_autocomplete_Amazon() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        /*driver.switchTo().frame(driver.findElement(By.className("demo-frame")));
        Thread.sleep(2000);*/

        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("n");
        //first we have to send a character.

        String texttobeclicked = "nespresso pods";// expected things to be clicked.
        WebElement autooptions  = driver.findElement(By.xpath("//*[@class='left-pane-results-container']"));

        try {
            wait.until(ExpectedConditions.visibilityOf(autooptions));
        } catch (TimeoutException e) {
            System.out.println("No element present with the character");
        }
        //we have to wait until the above element come in auto complete box.

        List<WebElement> alloptions = autooptions.findElements(By.tagName("div"));


        for (WebElement option : alloptions) {
            if (option.getText().equals(texttobeclicked)) {
                option.click();
                break;
            }
        }
        //All the options which will be coming are stored in a tagname li so that's
        //why we are doing the above code.


        Thread.sleep(3000);

    }

}
