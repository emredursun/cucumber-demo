package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.ConfigurationReader;
import utilities.Driver;

public class Hooks {

    @Before(value = "@ui")
    public void setUp(){
        utilities.Driver.getDriver().get(ConfigurationReader.getProperty("base_url_ui"));
    }

    @After(value = "@ui")
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) utilities.Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshots");
        }
        Driver.closeDriver();
    }
}
