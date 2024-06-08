package step_definitions;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.HomePage;
import pages.LoginPage;
import utilities.driver;
import utilities.driverFactory;


public class LoginSteps {

   private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);
  //  private WebDriver driver = driverFactory.getDriver("chrome");
    LoginPage lp= new LoginPage();
    HomePage hp = new HomePage();

    @Given("user navigates to orangeHRM login page")
    public void user_navigates_to_orange_hrm_login_page() {
        // Write code here that turns the phrase above into concrete actions
        driver.getDriver().get("http://dev-hrm.yoll.io/");
    }
    @When("user logs in with username {string} and password {string}")
    public void user_logs_in_with_valid_username_and_password(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
    lp.usernameInputBox.sendKeys(username);
    lp.passwordInputBox.sendKeys(password);
    user_clicks_login_button();
    }
    @When("user clicks login button")
    public void user_clicks_login_button() {
        // Write code here that turns the phrase above into concrete actions
lp.loginButton.click();
    }
    @Then("user is redirected to the homepage")
    public void user_is_redirected_to_the_homepage() {
        // Write code here that turns the phrase above into concrete actions
String actual = hp.welcomeElement.getText();
String expected = "Welcome Yoll";
        Assert.assertEquals("user redirected failed", expected,actual);
    }

@Then("quit the driver")
public void quitDriver(){
        driver.quitDriver();
}

    @When("user logs in with invalid username and password")
    public  void userEnterInvalidLogin(){
lp.login("invalid","invalid");
    }

    @Then("user can see an error message {string}") public void errorMsg(String expectedError){
        String actual = lp.errorMessageElement.getText();
        String expected = "Invalid credentials";
        Assert.assertEquals("Error message element failed", expectedError);
    }

}
