package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XPathChecker {
    private final WebDriver driver;

    public XPathChecker(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isTextPresent(String textToCheck, String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            return element != null && element.getText().contains(textToCheck);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isXPathValid(String xpath) {
        try {
            driver.findElement(By.xpath(xpath));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
