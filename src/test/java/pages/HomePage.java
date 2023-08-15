package pages;


import org.openqa.selenium.By;
import utilities.Driver;


public class HomePage {

    public void clickLinkWithText(String linkText){
        Driver.getDriver()
                .findElement(By.xpath(String.format("//a[text()='%s']", linkText))).click();
    }
}
