package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WaitPractice {
    public void ThreadSleep()throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        WebElement usernameInputBox = driver.findElement(By.id("user-name"));
        WebElement passwordInputBox =  driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameInputBox.sendKeys("performance-glitch-user");
        passwordInputBox.sendKeys("secret_sauce");
loginButton.click();
Thread.sleep(1000);

WebElement bp = driver.findElement(By.xpath("//*[text()='Sauce Labs Backpack']"));
bp.click();
Thread.sleep(1000);

WebElement back = driver.findElement(By.id("back-to-products"));
back.click();

Thread.sleep(1000);
WebElement bikeLightTitle = driver.findElement(By.xpath("//*[text()='Sauce Labs Bike Light']"));
bikeLightTitle.click();
driver.quit();}

    public void refactor()throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        WebElement usernameInputBox = driver.findElement(By.id("user-name"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        usernameInputBox.sendKeys("performance-glitch-user");
        passwordInputBox.sendKeys("secret_sauce");
        loginButton.click();
    }

}
