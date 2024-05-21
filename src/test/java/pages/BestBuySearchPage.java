package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BestBuySearchPage {
    public BestBuySearchPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id="gh-search-input")
    public WebElement searchInputBox;

    @FindBy(css=".header-search-button")
    public WebElement searchButton;


}
