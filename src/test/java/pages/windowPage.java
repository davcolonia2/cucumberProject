package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.driver;

import java.util.List;

public class windowPage {
//comment
    public windowPage() {
        PageFactory.initElements(driver.getDriver(), this);
    }
        @FindBy(id =  "tabButton")
        public WebElement newTabButton;

    @FindBy(id = "windowButton")
    public WebElement newWindowButton;

    @FindBy(id = "sampleHeading")
    public WebElement newTabContent;



    }

