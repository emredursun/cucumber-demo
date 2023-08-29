package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver driver;

    public static WebDriver getDriver() {
        if (driver == null) {
            String browser = ConfigurationReader.getProperty("browser");

            switch (browser){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;
                case "safari":
                    WebDriverManager.getInstance(SafariDriver.class);
                    driver=new SafariDriver();
                    break;
                case "chrome-headless":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = getChromeOptions();
                    driver = new ChromeDriver(options);
                    break;

                case "firefox-headless":
                    FirefoxOptions options2 = new FirefoxOptions();
                    options2.setHeadless(true);
                    driver = new FirefoxDriver(options2);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid browser name: " + browser);
            }
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return driver;
    }

    private static ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-extensions");
        options.addArguments("--proxy-server='direct://'");
        options.addArguments("--proxy-bypass-list=*");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-infobars");
        options.addArguments("--no-sandbox");
        options.addArguments("enable-automation");
        options.addArguments("--window-size=1920,1200");
        options.setHeadless(true);
        return options;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
