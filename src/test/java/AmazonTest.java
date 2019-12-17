import Models.BookModel;
import PageComponents.SearchResultComponent;
import PageObjects.AmazonHomePage;
import PageObjects.AmazonResultsPage;
import Utils.BrowserTypes;
import Utils.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;


public class AmazonTest {
    private DriverFactory driverFactory;
    private int timeOut = 5;

    @BeforeClass
    public void SetUp() {
        driverFactory = new DriverFactory();
        driverFactory.StartBrowser(BrowserTypes.Chrome, timeOut);
        driverFactory.GetDriver().navigate().to(Data.BaseUrl);
    }

    @Test
    public void VerifyingAmazonSearchResultsPAge()  {
        // Arrange
        String desiredBook = Data.TestBook;
        boolean expectedResult = true;

        // Act
        boolean actual = IsBookInSearchResults(desiredBook, FillingInputAndApplyingFilter(Data.TestData1, Data.FilterOption));

        // Accert
        Assert.assertEquals(expectedResult, actual);
    }

    private  AmazonResultsPage FillingInputAndApplyingFilter(String inputValue, String filterValue) {
        AmazonHomePage homePage = new AmazonHomePage(driverFactory.GetDriver(), driverFactory.GetDriverWait());
        homePage.FillInput(inputValue);
        homePage.SetFilterOptionProgrammatically(filterValue);
        homePage.ClickOnSearchButton();
        return new AmazonResultsPage(driverFactory.GetDriver(), driverFactory.GetDriverWait());
    }

    private boolean IsBookInSearchResults(String bookName, AmazonResultsPage resultsPage) {
        boolean result = false;
        List <BookModel> results = resultsPage.GetBooks();
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
        driverFactory.StopDriver();
    }
}
