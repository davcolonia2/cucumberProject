package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class driverFactory {
    public static WebDriver getDriver(String browser){
        return switch(browser){
            case "firefox"-> new FirefoxDriver();
            case "safari"-> new SafariDriver();
            case "edge"-> new EdgeDriver();
            default ->  new ChromeDriver();
        };

    }


}
