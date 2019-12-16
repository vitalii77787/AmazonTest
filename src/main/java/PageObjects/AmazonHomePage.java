package PageObjects;

import Utils.PageObjectHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage extends BasePage {
    public AmazonHomePage(WebDriver _driver, WebDriverWait _wait) {
        super(_driver, _wait);
    }

    public AmazonHomePage(WebDriver _driver) {
        super(_driver);
    }

    protected WebElement InputField() {
        return this.driver.findElement(By.cssSelector("#twotabsearchtextbox"));
    }

    protected WebElement SelectButton() {
        return DriverFindElementWithWait(By.cssSelector("#nav-search-dropdown-card>.nav-search-scope.nav-sprite"));
    }

    protected WebElement SelectElement() {
        return DriverFindElementWithWait(By.cssSelector("select"));
    }

    protected WebElement SearchButton() {
        return this.driver.findElement(By.cssSelector("#nav-search .nav-right .nav-input"));
    }

    public void FillInputAndClickEnter(String inputText) {
        PageObjectHelper.FillInputAndClickEnterKey(InputField(), inputText);
    }

    public void FillInput(String inputText) {
        PageObjectHelper.FillInput(InputField(), inputText);
    }

    public void FillInputAndClickSearchButton(String inputText) {
        PageObjectHelper.FillInput(InputField(), inputText);
        SearchButton().click();
    }

    public void ClickOnSearchButton() {
        this.SearchButton().click();
    }

    public void SelectItemFromSelectElement(String item) {
        SelectButton().click();
        Select filterSelect = new Select(SelectElement());
        filterSelect.selectByVisibleText(item);
    }
}
