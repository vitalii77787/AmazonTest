package PageObjects;

import Models.BookModel;
import PageComponents.SearchResultComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.*;

public class AmazonResultsPage extends BasePage {
    public AmazonResultsPage(WebDriver _driver, WebDriverWait _wait) {
        super(_driver, _wait);
    }

    public AmazonResultsPage(WebDriver _driver) {
        super(_driver);
    }


    protected List<WebElement> searchResultElements() {
        return driverFindElementsWithWait(By.cssSelector(".s-result-list.s-search-results.sg-row>.sg-col-20-of-24"));
    }

    protected List<SearchResultComponent> getSearchResults() {
        List<SearchResultComponent> searchResultsList = new ArrayList<SearchResultComponent>();
        for (WebElement item : searchResultElements()) {
            searchResultsList.add(new SearchResultComponent(item));
        }
        return searchResultsList;
    }

    public int getResultsCount() {
        return getSearchResults().size();
    }

    public List<BookModel> getBooks () {
        List<BookModel> books = new ArrayList<>();
        for (SearchResultComponent item : getSearchResults()){
            books.add(item.getBookModel());
        }
        return books;
    }
}
