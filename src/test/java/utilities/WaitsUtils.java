package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.time.Duration;

public class WaitsUtils {
public static void waitForVisibilityOfElement(WebElement element, int seconds){
    Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(seconds));
    wait.until(ExpectedConditions.visibilityOf(element));
}

public static void waitForClickabilityOfElement(WebElement element, int seconds){
    Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(seconds));
    wait.until(ExpectedConditions.elementToBeClickable(element));
}

public static void waitForNumberOfWindows(int numberofwindows, int seconds){
    Wait<WebDriver> wait = new WebDriverWait(driver.getDriver(), Duration.ofSeconds(seconds));
wait.until(ExpectedConditions.numberOfWindowsToBe(numberofwindows));
}

}
