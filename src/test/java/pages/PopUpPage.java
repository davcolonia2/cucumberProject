package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.driver;

public class PopUpPage {

    public PopUpPage(){
        PageFactory.initElements(driver.getDriver(),this);
    }

    @FindBy(css = "div.modal-title>h3")
        public WebElement modalTitle;

    @FindBy(css ="div.modal-footer>p")
    public WebElement close;

    @FindBy(id ="modal")
    public WebElement modal;

}
