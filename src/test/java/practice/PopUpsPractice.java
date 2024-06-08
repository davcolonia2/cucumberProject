package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopUpsPractice {
    @Test
    public void testModal() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/entry_ad");
        Wait<WebDriver>wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        String expected = "THIS IS A MODAL WINDOW";
        WebElement modal = driver.findElement(By.cssSelector("div.modal-title>h3"));
        wait.until(ExpectedConditions.visibilityOf(modal));
        String actual = modal.getText();

        System.out.println("Actual " + actual);
        System.out.println("Expected "+ expected);
        Assert.assertTrue("failed test",actual.equalsIgnoreCase(expected));


        WebElement close = driver.findElement(By.cssSelector("div.modal-footer>p"));
        close.click();

//        boolean titleDisplay = modal.isDisplayed();
//        Assert.assertFalse("modal is displayed",titleDisplay);
//
        Wait<WebDriver>wait2 = new WebDriverWait(driver,Duration.ofSeconds(5));
        boolean isInvisible = wait2.until(ExpectedConditions.invisibilityOf(modal));
        Assert.assertTrue(isInvisible);

        driver.quit();

    }

@Test
public void testBrowserAlert() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement clickJsAlertButton = driver.findElement(By.xpath("//*[text()='Click for JS Alert']"));
        clickJsAlertButton.click();

        Wait<WebDriver>wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        System.out.println("alert description "+alert.getText());
        Thread.sleep(2000);

        alert.accept();
        Thread.sleep(2000);

        WebElement messageResult = driver.findElement(By.id("result"));
        System.out.println("messageResult "+messageResult.getText());
    driver.quit();
    Thread.sleep(2000);}

    @Test
    public void testBrowserConfirmAlert() throws InterruptedException {
    WebDriver driver = new ChromeDriver();
    driver.get("https://the-internet.herokuapp.com/javascript_alerts");
Thread.sleep(2000);

    WebElement jsConfirmButton = driver.findElement(By.xpath("//*[text()= 'Click for JS Alert']"));
    jsConfirmButton.click();

    Wait<WebDriver> wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);

        Alert alert = driver.switchTo().alert();
    System.out.println(alert.getText());
    alert.dismiss();
        Thread.sleep(2000);

    WebElement messageResult = driver.findElement(By.id("result"));
    System.out.println(messageResult.getText());

    jsConfirmButton.click();
    wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);

    alert.accept();

    messageResult = driver.findElement(By.id("result"));
    System.out.println(messageResult.getText());
        Thread.sleep(2000);

    driver.quit();


    }



}
