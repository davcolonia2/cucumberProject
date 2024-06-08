package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.PopUpPage;
import utilities.driver;

import java.time.Duration;

public class PopUpsSteps {


private final static String EXPECTED_MODAL_TITLE = "THIS IS A MODAL WINDOW";
private PopUpPage popUpPage = new PopUpPage();
    @Given("user lands on Entry Ad page")
    public void user_lands_on_entry_ad_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.getDriver().get("https://the-internet.herokuapp.com/entry_ad");
    }
    @When("a pop-up appears")
    public void a_pop_up_appears() {
        // Write code here that turns the phrase above into concrete actions
        Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(popUpPage.modalTitle));
        Assert.assertTrue("failed test",popUpPage.modalTitle.isDisplayed());
    }
    @Then("user is able to see {string}")
    public void user_is_able_to_see(String string) {
        // Write code here that turns the phrase above into concrete actions
String actual = popUpPage.modalTitle.getText();
Assert.assertTrue("title verificaiton failed ", actual.equalsIgnoreCase(EXPECTED_MODAL_TITLE));
    }
    @Then("user can close the pop-up")
    public void user_can_close_the_pop_up() {
        // Write code here that turns the phrase above into concrete actions
popUpPage.close.click();
        Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(10));
        boolean isInvisible = wait.until(ExpectedConditions.invisibilityOf(popUpPage.modalTitle));
        Assert.assertTrue("modal is still open", isInvisible);

    }


}
