package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class DriverXL {

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverXL.class);

    private static final Map<Browser, WebDriver> drivers = new ConcurrentHashMap<>();

    private DriverXL() {
    }

    public static WebDriver getDriver(Browser browser) {
        if (!drivers.containsKey(browser)) {
            WebDriver driver = createDriver(browser);
            drivers.put(browser, driver);
        }
        return drivers.get(browser);
    }

    public static void closeDriver(Browser browser) {
        if (drivers.containsKey(browser)) {
            drivers.get(browser).quit();
            drivers.remove(browser);
        }
    }

    private static WebDriver createDriver(Browser browser) {
        String browserName = browser.name();
        LOGGER.info("Creating WebDriver for browser: {}", browserName);
        WebDriver driver;
        switch (browserName) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "safari":
                WebDriverManager.getInstance(SafariDriver.class);
                driver = new SafariDriver();
                break;
            case "chrome-headless":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(true);
                driver = new ChromeDriver(chromeOptions);
                break;
            case "firefox-headless":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setHeadless(true);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new IllegalArgumentException(String.format("Unsupported browser: %s", browserName));
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
        return driver;
    }

    public enum Browser {
        Chrome("chrome"),
        Firefox("firefox"),
        Safari("safari"),
        ChromeHeadless("chrome-headless"),
        FirefoxHeadless("firefox-headless");

        private final String name;

        Browser(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}

