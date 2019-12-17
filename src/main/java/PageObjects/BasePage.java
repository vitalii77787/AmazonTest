package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import java.util.List;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    protected int defaultTimeout = 5;

    public BasePage(WebDriver _driver, WebDriverWait _wait) {
        this.driver = _driver;
        this.driverWait = _wait;
    }

    public BasePage(WebDriver _driver) {
        this.driver = _driver;
        this.driverWait = new WebDriverWait(driver, defaultTimeout);
    }

    protected WebElement DriverFindElementWithWait(By by) {
        return driverWait.until(ExpectedConditions.elementToBeClickable(by));
    }

    protected List<WebElement> DriverFindElementsWithWait(By by) {
        return driverWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    protected void ExecuteScript(String script) {
        JavascriptExecutor.class.cast(this.driver).executeScript(script);
    }
}
