package utilities;

import org.openqa.selenium.WebDriver;
public class driver {

    private static WebDriver driver;

    private driver(){}

    public static WebDriver getDriver(){
        if(driver==null){
            driver=driverFactory.getDriver(ConfigReader.getProperty("browserType"));
        }
        return driver;
    }
    //singleton quit

    public static void  quitDriver(){
        if(driver != null){
            driver.quit();
            driver= null;
        }
    }


}
