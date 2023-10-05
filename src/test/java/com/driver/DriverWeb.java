package com.driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class DriverWeb {

    @Test
    public void apple() {
        WebDriver driver = SingletonBrowserClass.getInstanceOfSingletonBrowserClass().getDriver();

        driver.get("https://www.amazon.com/");
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("n");
        String texttobeclicked = "nespresso pods";
        WebElement autooptions  = SingletonBrowserClass.getInstanceOfSingletonBrowserClass().getDriver().findElement(By.xpath("//*[@class='left-pane-results-container']"));
        SingletonBrowserClass.getInstanceOwait(ExpectedConditions.visibilityOf(autooptions));
    }

}
