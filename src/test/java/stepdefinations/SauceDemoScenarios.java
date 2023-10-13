package stepdefinations;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.SingletonBrowserClass;
import org.openqa.selenium.By;

import org.testng.Assert;

public class SauceDemoScenarios {

    @Given("User navigated to url {string}")
    public void user_navigated_to_url(String url) {
        //StaticInstances.sbc.getDriver().get(url);
        SingletonBrowserClass.getInstanceOfSingletonBrowserClass().getDriver().get(url);
    }

    @When("User enters username {string}")
    public void user_enters_username(String username) {
        SingletonBrowserClass.getInstanceOfSingletonBrowserClass().getDriver().findElement(By.cssSelector("input[id='user-name']")).sendKeys(username);
    }

    @Then("user enters password {string}")
    public void user_enters_password(String password) {
        SingletonBrowserClass.getInstanceOfSingletonBrowserClass().getDriver().findElement(By.cssSelector("input[id='password']")).sendKeys(password);
    }

    @And("User clicks on login button")
    public void user_clicks_on_login_button() throws InterruptedException {
        SingletonBrowserClass.getInstanceOfSingletonBrowserClass().getDriver().findElement(By.cssSelector("input[id='login-button']")).click();
        Thread.sleep(5000);
    }

    @Then("User should see a error message {string}")
    public void user_should_see_a_error_message(String error_message) {
        SingletonBrowserClass.getInstanceOfSingletonBrowserClass().getDriver().findElement(By.cssSelector("input[id='login-button']")).click();
        String errortext = SingletonBrowserClass.getInstanceOfSingletonBrowserClass().getDriver().findElement(By.xpath("//div[contains(@class,'error-message-container')]/h3[contains(text(),'"+error_message+"')]")).getText();
        if (errortext.contains(error_message)){
            Assert.assertTrue(true);
        }
        else {
            Assert.fail("Text doesn't contains locked out user");
        }
    }



}
