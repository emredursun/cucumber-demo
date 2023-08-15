package stepdefinitions.ui;

import io.cucumber.java.en.Given;
import pages.BasePage;
import pages.HomePage;

public class BasePageSteps {

    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        homePage.clickLinkWithText("Home");
    }
}
