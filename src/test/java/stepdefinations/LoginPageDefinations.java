package stepdefinations;

import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.Given;
//import org.openqa.selenium.WebDriver;
import utils.SingletonBrowserClass;

public class LoginPageDefinations {

    @Given("User is in {string} homepage {string}")
    public void user_is_in_homepage(String string, String string2) {
        //WebDriver driver = utils.SingletonBrowserClass.getInstanceOfSingletonBrowserClass();
        SingletonBrowserClass.getInstanceOfSingletonBrowserClass().getDriver().get("https://www.saucedemo.com/");
    }
    @When("User enters correct username {string}")
    public void user_enters_correct_username(String string) {
        System.out.println("Test");
    }

    @When("User enters correct password {string}")
    public void user_enters_correct_password(String string) {
        System.out.println("Test2");
    }
    @Then("User should be able to login")
    public void user_should_be_able_to_login() {
        System.out.println("Test3");
    }
}
