package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverFactory {
    private WebDriver driver;
    private WebDriverWait driverWait;

    public DriverFactory() {
    }

    public WebDriver getDriver() {
        if (driver == null) {
            throw new NullPointerException("The WebDriver browser instance was not initialized.");
        }
        return driver;
    }

    public WebDriverWait getDriverWait() {
        if (driver == null || driverWait == null) {
            throw new NullPointerException("The WebDriver browser instance was not initialized.");
        }
        return driverWait;
    }

    public void startBrowser(BrowserTypes browserType, int defaultTimeOut) {
        switch (browserType) {
            case Chrome:
                driver = BuildWebDriver.buildChromeDriver();
                break;
            case FireFox:
                driver = BuildWebDriver.buildFirefoxDriver();
                break;
            default:
                driver = BuildWebDriver.buildChromeDriver();
                break;
        }
        driver.manage().window().maximize();
        driverWait = new WebDriverWait(driver, defaultTimeOut);
    }

    public void stopDriver() {
        driver.quit();
        driver = null;
        driverWait = null;
    }
}
