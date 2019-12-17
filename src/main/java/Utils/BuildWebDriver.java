package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import static io.github.bonigarcia.wdm.DriverManagerType.*;

public class BuildWebDriver {

    public static WebDriver buildChromeDriver() {
        WebDriverManager.getInstance(CHROME).setup();
        return new ChromeDriver();
    }

    public static WebDriver buildFirefoxDriver() {
        WebDriverManager.getInstance(FIREFOX).setup();
        return new FirefoxDriver();
    }

    public static WebDriver buildExplorerDriver() {
        WebDriverManager.getInstance(IEXPLORER).setup();
        return new InternetExplorerDriver();
    }
}
