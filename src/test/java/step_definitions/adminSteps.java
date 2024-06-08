package step_definitions;

import io.cucumber.core.logging.Logger;
import io.cucumber.core.logging.LoggerFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.HomePage;
import pages.LoginPage;
import utilities.driverFactory;

import java.util.List;

public class adminSteps {

    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);
  //  private WebDriver driver = driverFactory.getDriver("chrome");
    LoginPage lp= new LoginPage();
    HomePage hp = new HomePage();

@Then("user can see the following tabs:")
public void tabs_count(List<String>ExpectedTabs){
List<WebElement> actualTabs = hp.tabs;
    Assert.assertEquals("Verification fail",ExpectedTabs.size(),actualTabs.size());

for(int i =0;i< ExpectedTabs.size();i++){
    String expectedTab = ExpectedTabs.get(i);
    String realTab = actualTabs.get(i).getText();
Assert.assertEquals("failed",expectedTab,realTab);

}
}
//ensure tab & name order






}
