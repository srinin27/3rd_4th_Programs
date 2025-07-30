package TestScripts;

import CommonLib.BaseTest;
import CommonLib.appLibrary;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.SearchResultsPage;

public class FlightBookingTest extends BaseTest {

    @BeforeMethod
    public void browserLaunch() {
        setup();
    }

    @Test
    public void roundTripSearch() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.launchPopup.click();
        appLibrary.wait(driver, homePage.flightTab, 10);
        homePage.selectFlightTab();
        appLibrary.wait(driver, homePage.roundTripOption, 10);
        homePage.selectRoundTrip();
        Thread.sleep(4000);
        homePage.enterFromCity("Hyderabad");
        Thread.sleep(4000);
        homePage.enterToCity("Chennai");
        Thread.sleep(4000);
        homePage.selectDates("10-Aug-2025");
        Thread.sleep(4000);
        homePage.selectDates("12-Sep-2025");
        Thread.sleep(4000);
        homePage.clickSearch();
        Thread.sleep(6000);

        SearchResultsPage resultsPage = new SearchResultsPage(driver);

        if (resultsPage.isSearchResultDisplayed()) {
            System.out.println("Test Passed: Search Results displayed!");
        } else {
            System.out.println("Test Failed: Search Results NOT displayed!");
        }
    }

    @AfterMethod
    public void closeBrowser() {
        tearDown();
    }

}