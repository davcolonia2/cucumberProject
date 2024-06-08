package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.service.DriverFinder;
import pages.BestBuySearchPage;
import utilities.ConfigReader;
import utilities.driver;
import utilities.driverFactory;

public class bestBuyStesps {
   // private WebDriver driver = driverFactory.getDriver("chrome");
    private BestBuySearchPage bp = new BestBuySearchPage();
    @Given("user navigates to best buy")
    public void navigateBestBuy(){
driver.getDriver().navigate().to(ConfigReader.getProperty("bestbuy_url"));
    }
    @When("user enters {string} in search box")
    public void enterSearch(String productName){
bp.searchInputBox.sendKeys(productName);
bp.searchButton.click();

    }


}
