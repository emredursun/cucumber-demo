package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Driver;

import static com.codeborne.selenide.Selenide.$;

public class BasePage {

    public WebElement getElementWithText(String elText){
        return Driver.getDriver().
                findElement(By.xpath(String.format("//*[text()='%s']", elText)));
    }
}
