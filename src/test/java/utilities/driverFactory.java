package utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;

public class driverFactory {

    private static final String AD_BLOCKER_PATH = "	C:/Users/hdl32da01/AppData/Local/Google/Chrome/User Data/Default/Extensions/gighmmpiobklfepjocnamgkkbiglidom/";
    public static WebDriver getDriver(String browser){
        return switch(browser){
            case "firefox"-> new FirefoxDriver();
            case "safari"-> new SafariDriver();
            case "edge"-> new EdgeDriver();
            default ->  new ChromeDriver();
        };

    }

    private static WebDriver createChromeDriverWithAdBlocker() {
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File(AD_BLOCKER_PATH));
        return new ChromeDriver(options);


    }
}
