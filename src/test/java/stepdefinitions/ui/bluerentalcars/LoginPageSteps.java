package stepdefinitions.ui.bluerentalcars;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.bluerentalcars.DefaultPage;
import pages.bluerentalcars.HomePage;
import pages.bluerentalcars.LoginPage;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.HashMap;

public class LoginPageSteps {
    HomePage homePage = new HomePage();
    LoginPage loginPage = new LoginPage();
    DefaultPage defaultPage = new DefaultPage();
//    ReusableMethods reusableMethods = new ReusableMethods();
    private static final String APP_URL = ConfigurationReader.getProperty("app_url");

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        Driver.getDriver().get(APP_URL);
    }

    @And("user login dropdown")
    public void userLoginDropdown() {
        homePage.homeLoginButton.click();
    }

    @And("user enters admin_username and admin_password")
    public void userEntersAdmin_usernameAndAdmin_password(DataTable table) {
        HashMap<String, String> properties = ReusableMethods.convertDataTable(table);
        loginPage.username.sendKeys(properties.get("username"));
        loginPage.password.sendKeys(properties.get("password"));
    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.loginButton.click();
    }

    @Then("verify the login is successful")
    public void verifyTheLoginIsSuccessful() {
        Assert.assertTrue(defaultPage.userID.isDisplayed());
    }
}
