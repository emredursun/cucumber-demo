package stepdefinitions.ui.uitestingplayground;

import io.cucumber.java.en.Given;
import pages.uitestingplayground.BasePage;
import pages.uitestingplayground.HomePage;

public class BasePageSteps {

    BasePage basePage = new BasePage();
    HomePage homePage = new HomePage();

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        homePage.clickLinkWithText("Home");
    }

}
