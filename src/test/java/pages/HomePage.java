package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.driver;

import java.util.List;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(driver.getDriver(),this);
    }

    @FindBy(id="welcome")
    public WebElement welcomeElement;

    @FindBy(xpath = "//*[@id='wrapper']//b")
    public List<WebElement> tabs;
    @FindBy(id="menu_admin_viewAdminModule")
    public WebElement adminTab;


}
