package practice;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFramesPractice {
    @Test public void interact() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/iframe");
        Thread.sleep(2000);

        //WebElement Iframe = driver.findElement(By.cssSelector("[title = 'YouTube video player'"));
        driver.switchTo().frame("iframe-youtube");
        Thread.sleep(2000);
        WebElement playButton = driver.findElement(By.cssSelector("button[title=Play]"));
playButton.click();
        Thread.sleep(2000);


        driver.switchTo().frame("mce_ifr");
        WebElement content = driver.findElement(By.cssSelector("#tinymce > p"));
        System.out.println(content.getText());
        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        WebElement title = driver.findElement(By.xpath("//*[text()= 'Internal IFrame: Email Subscription']"));
        title.sendKeys(Keys.SPACE);

        driver.switchTo().frame("email-subscribe");
        WebElement emailInput = driver.findElement(By.id("email"));
        Thread.sleep(2000);

        Faker faker = new Faker();
        emailInput.sendKeys(faker.internet().emailAddress());
        emailInput.sendKeys(Keys.PAGE_DOWN);
Thread.sleep(2000);

        WebElement subscribe = driver.findElement(By.id("btn-subscription"));
        subscribe.click();
        Thread.sleep(4000);

        driver.quit();

    }




}
