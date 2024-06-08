package pages;
import com.github.javafaker.Faker;
import org.junit.runner.manipulation.Ordering;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import practice.IFramesPractice;
import utilities.driver;

import java.sql.Driver;

public class IFramesPage {
    public IFramesPage(){
        PageFactory.initElements(driver.getDriver(),this);
    }


    @FindBy(css = "button[title=Play]")
    public WebElement playButton;

    @FindBy(css = "#tinymce > p")
    public WebElement editorContent;

    @FindBy(id = "email")
    public WebElement emailInputBox;

    @FindBy(id ="btn-subscribe")
    public WebElement subscribeButton;

    @FindBy(id = "success-message")
    public WebElement element;

    public String getRandomEmail(){
        return new Faker().internet().emailAddress();
    }


}
