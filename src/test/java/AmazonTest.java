import PageObjects.AmazonHomePage;
import PageObjects.AmazonResultsPage;
import Utils.BrowserTypes;
import Utils.DriverFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class AmazonTest {
    private DriverFactory driverFactory;
    private int timeOut = 5;

    @BeforeClass
    public void SetUp() {
        driverFactory = new DriverFactory();
        driverFactory.StartBrowser(BrowserTypes.FireFox, timeOut);
        driverFactory.GetDriver().navigate().to(Data.BaseUrl);
    }

    @Test
    public void VerifyingAmazonSearchResultsPAge()  {
        AmazonHomePage homePage = new AmazonHomePage(driverFactory.GetDriver(), driverFactory.GetDriverWait());
        homePage.FillInput(Data.TestData1);
        homePage.SelectItemFromSelectElement(Data.FilterOption);
        homePage.ClickOnSearchButton();
    }
    @AfterClass
    public void TierDown() {
        driverFactory.StopDriver();
    }
}
