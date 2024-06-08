package step_definitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.driver;

import java.time.Duration;

public class hooks {
    @Before
    public void setUp(){
        driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.getDriver().manage().window().maximize();
    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte [] screenshot = ((TakesScreenshot)driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/jpeg","result.jpg");
        }
        driver.quitDriver();

    }


}
