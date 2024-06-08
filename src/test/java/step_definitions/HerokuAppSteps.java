package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;
import pages.HerokuAppPage;
import utilities.driver;

import java.sql.Driver;
import java.time.Duration;

public class HerokuAppSteps {

private HerokuAppPage HAP = new HerokuAppPage();
    @Given("user is on heroku dynamic loading page")
    public void user_is_on_heroku_dynamic_loading_page() {
        // Write code here that turns the phrase above into concrete actions
driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading");
    }
    @When("user clicks on example one link")
    public void user_clicks_on_example_one_link() {
        // Write code here that turns the phrase above into concrete actions
        Wait<WebDriver> explicitWait = new WebDriverWait(driver.getDriver(),Duration.ofSeconds(15));
        explicitWait.until(ExpectedConditions.elementToBeClickable(HAP.exampleOneLink));
HAP.exampleOneLink.click();
    }
    @When("user clicks on the start button")
    public void user_clicks_on_the_start_button() {
        // Write code here that turns the phrase above into concrete actions
        Wait<WebDriver> explicitWait = new WebDriverWait(driver.getDriver(),Duration.ofSeconds(15));
        explicitWait.until(ExpectedConditions.elementToBeClickable(HAP.startButton));
        HAP.startButton.click();
    }
    @Then("user can see a {string} message")
    public void user_can_see_a_message(String expectedMessage) {
        // Write code here that turns the phrase above into concrete actions
       // Wait<WebDriver> explWait = new WebDriverWait(driver.getDriver(),Duration.ofSeconds(10));
        //explWait.until(ExpectedConditions.visibilityOf(HAP.message));

        Wait<WebDriver>fluentWait = new FluentWait<>(driver.getDriver()).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(250)).ignoring(NoSuchElementException.class).withMessage("The element failed to locate within 10 seconds with polling time of 250 mills");

        fluentWait.until(ExpectedConditions.visibilityOf(HAP.message));
        String actual = HAP.message.getText();


        Assert.assertEquals("verification fails",expectedMessage,actual);

    }




}
