package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(driver.getDriver(),this);
    }
    @FindBy(id="txtUsername")
    public WebElement usernameInputBox;

    @FindBy(css="#txtPassword")
    public WebElement passwordInputBox;

    @FindBy(xpath="//*[@id='btnLogin']")
    public WebElement loginButton;

    @FindBy(id ="spanMessage")
    public WebElement errorMessageElement;



    public String getError(){
        return errorMessageElement.getText();
    }
    public void login(String username, String password){
        usernameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        loginButton.click();
    }

}