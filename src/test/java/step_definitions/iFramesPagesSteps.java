package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.IFramesPage;
import practice.IFramesPractice;
import utilities.ConfigReader;
import utilities.WaitsUtils;
import utilities.driver;

public class iFramesPagesSteps {

private IFramesPage iFramesPage = new IFramesPage();
    @Given("user lands on expendtesting page")
    public void user_lands_on_expendtesting_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.getDriver().get(ConfigReader.getProperty("iframes_url"));
    }
    @When("user clicks on video play button")
    public void user_clicks_on_video_play_button() {
        // Write code here that turns the phrase above into concrete actions
driver.getDriver().switchTo().frame("iframe-youtube");
        WaitsUtils.waitForClickabilityOfElement(iFramesPage.playButton,2);
iFramesPage.playButton.click();
    }
    @Then("user can see {string}")
    public void user_can_see(String expectedMessage) {
        // Write code here that turns the phrase above into concrete actions
        if (expectedMessage.contains("content")) {
            driver.getDriver().switchTo().parentFrame();
            driver.getDriver().switchTo().frame("mce_0_ifr");
            String contentMessage = iFramesPage.editorContent.getText();
            Assert.assertEquals("verification failed editor",expectedMessage,contentMessage);
        } else {
            WaitsUtils.waitForVisibilityOfElement(iFramesPage.element, 2);
            String elementMessage = iFramesPage.element.getText();
            Assert.assertEquals("verificaiton failed subscribe",elementMessage,expectedMessage);
        }
    }
    @When("user enters the email")
    public void user_enters_the_email() {
        // Write code here that turns the phrase above into concrete actions
driver.getDriver().switchTo().defaultContent();
driver.getDriver().switchTo().frame("email-subscribe");
WaitsUtils.waitForVisibilityOfElement(iFramesPage.emailInputBox,2);
iFramesPage.emailInputBox.sendKeys(iFramesPage.getRandomEmail());
        iFramesPage.emailInputBox.sendKeys(Keys.PAGE_DOWN);
    }
    @When("clicks subscribe button")
    public void clicks_subscribe_button() {
        // Write code here that turns the phrase above into concrete actions
        WaitsUtils.waitForClickabilityOfElement(iFramesPage.subscribeButton,2);
        iFramesPage.subscribeButton.click();
    }




}
