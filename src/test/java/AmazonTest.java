import Models.BookModel;
import PageObjects.AmazonHomePage;
import PageObjects.AmazonResultsPage;
import Utils.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static Utils.StringToTypeMaper.mapParameter;


public class AmazonTest {
    private DriverFactory driverFactory;
    private int timeOut = 5;

    @BeforeClass
    public void SetUp() {
        driverFactory = new DriverFactory();
         String browserName = System.getProperty("browser");
        driverFactory.startBrowser(mapParameter(browserName), timeOut);
        driverFactory.getDriver().navigate().to(Data.BASEURL);
    }

    @Test
    public void verifyingAmazonSearchResultsPAge() {
        // Arrange
        String desiredBook = Data.TEST_BOOK;
        boolean expectedResult = true;

        // Act
        boolean actual = isBookInSearchResults(desiredBook, fillingInputAndApplyingFilter(Data.TESTDATA_FOR_INPUT_SEARCH, Data.FILTER_OPTION));

        // Assert
        Assert.assertEquals(expectedResult, actual);
    }

    private AmazonResultsPage fillingInputAndApplyingFilter(String inputValue, String filterValue) {
        AmazonHomePage homePage = new AmazonHomePage(driverFactory.getDriver(), driverFactory.getDriverWait());
        homePage.FillInput(inputValue);
        homePage.setFilterOptionProgrammatically(filterValue);
        homePage.ClickOnSearchButton();
        return new AmazonResultsPage(driverFactory.getDriver(), driverFactory.getDriverWait());
    }

    private boolean isBookInSearchResults(String bookName, AmazonResultsPage resultsPage) {
        boolean result = false;
        List<BookModel> results = resultsPage.getBooks();
        for (BookModel item : results) {
            if (item.getBookName().equals(bookName)) {
                result = true;
                break;
            }
        }
        return result;
    }

    @AfterClass
    public void TierDown() {
        driverFactory.stopDriver();
    }
}
