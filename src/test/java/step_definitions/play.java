package step_definitions;

import utilities.driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class play {

    public static void main(String[] args) throws IOException {
        driver.getDriver().get("https://www.ebay.com/");
        driver.quitDriver();


        Properties myProperties = new Properties();
        String path = "src/test/resources/configs.properties";
        FileInputStream fileInputStream = new FileInputStream(path);
        myProperties.load(fileInputStream);
System.out.println(myProperties.getProperty("hrm_url"));

    }

}
