package stepdefinitions.ui.bluerentalcars;

import io.cucumber.java.en.Then;
import utilities.Driver;

public class CommonSteps {

    @Then("close the app")
    public void closeTheApp() {
        Driver.getDriver().close();
    }
}
