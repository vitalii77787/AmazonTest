package PageObjects;

import Utils.PageObjectHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonHomePage extends BasePage {
    private final String FilterSelector = "#searchDropdownBox";

    public AmazonHomePage(WebDriver _driver, WebDriverWait _wait) {
        super(_driver, _wait);
    }

    public AmazonHomePage(WebDriver _driver) {
        super(_driver);
    }

    protected WebElement inputField() {
        return this.driver.findElement(By.cssSelector("#twotabsearchtextbox"));
    }

    protected WebElement selectButton() {
        return driverFindElementWithWait(By.cssSelector("#nav-search-dropdown-card>.nav-search-scope.nav-sprite"));
    }

    protected WebElement selectElement() {
        return driverFindElementWithWait(By.cssSelector(FilterSelector));
    }

    protected WebElement searchButton() {
        return this.driver.findElement(By.cssSelector("#nav-search .nav-right .nav-input"));
    }

    protected void setFilterOptionWithJs(String selector, String option) {
        String script = String.format("document.querySelector('%s')." +
                "selectedIndex = [...document.querySelector('%s').options]" +
                ".findIndex (option => option.text === '%s');", selector, selector, option);
        executeScript(script);
    }

    public void setFilterOptionProgrammatically(String option) {
        setFilterOptionWithJs(FilterSelector, option);
    }

    public void FillInputAndClickEnter(String inputText) {
        PageObjectHelper.fillInputAndClickEnterKey(inputField(), inputText);
    }

    public void FillInput(String inputText) {
        PageObjectHelper.fillInput(inputField(), inputText);
    }

    public void FillInputAndClickSearchButton(String inputText) {
        PageObjectHelper.fillInput(inputField(), inputText);
        searchButton().click();
    }

    public void ClickOnSearchButton() {
        this.searchButton().click();
    }

    // Not working code
    // public void selectItemFromSelectElement(String item) {
    //     SelectButton().click();
    //     Select filterSelect = new Select(SelectElement());
    //     filterSelect.selectByVisibleText(item); 
    // }
}
