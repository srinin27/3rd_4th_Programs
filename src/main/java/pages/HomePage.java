package pages;

import CommonLib.appLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    WebDriver driver;

    // Locators
    @FindBy(xpath = "//*[@id=\"SW\"]/div[1]/div[2]/div[2]/div/section/span")
    public WebElement launchPopup;

    @FindBy(xpath = "//span[text()='Flights']")
    public WebElement flightTab;

    @FindBy(xpath = "//li[@data-cy='roundTrip']/span")
    public WebElement roundTripOption;

    @FindBy(id = "fromCity")
    WebElement fromCity;

    @FindBy(xpath = "//input[@placeholder='From']")
    WebElement fromInput;

    @FindBy(xpath = "//*[@id='react-autowhatever-1']/div/ul/li[contains(@id, 'item-0')]")
    WebElement selectFromCityFrmDropDown;

    @FindBy(id = "toCity")
    WebElement toCity;

    @FindBy(xpath = "//input[@placeholder='To']")
    WebElement toInput;

    @FindBy(xpath = "//*[@id='react-autowhatever-1']/div/ul/li[contains(@id, 'item-0')]")
    WebElement selectToCityFrmDropDown;

    @FindBy(xpath = "//p[@data-cy='submit']/a")
    public WebElement searchButton;

    @FindBy(xpath = "//span[@role='button'][@aria-label='Next Month']")
    WebElement nextMonthNav;
/*
    @FindBy(xpath = "//div[@class='DayPicker-Months']//div[@class='DayPicker-Caption']/div[contains(text(),'{0}}')]")
    WebElement monthName;

    @FindBy(xpath = "//div[@class='DayPicker-Months']//div[@class='DayPicker-Caption']/div[contains(text(),'{0}')]/span[contains(text(),'{1}')]")
    WebElement yearName;

    String str = date.split("-")[1] + " "+date.split("-")[0];
    WebElement startDate = driver.findElement(By.xpath("//div[contains(@class,'DayPicker-Day')][contains(@aria-label,'" + str + "')]"));
    */

    @FindBy(xpath = "//div[@class='DayPicker-Months']//div[@class='DayPicker-Caption']")
    List<WebElement> monthslist;

    public WebElement dynamicWebElement_monthName(String month) {
        String xpath = "//div[@class='DayPicker-Months']//div[@class='DayPicker-Caption']/div[contains(text(),'" + month + "' )]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement dynamicWebElement_yearName(String month, String year) {
        String xpath = "//div[@class='DayPicker-Months']//div[@class='DayPicker-Caption']/div[contains(text(),'" + month + "')]/span[contains(text(),'" + year + "')]";
        return driver.findElement(By.xpath(xpath));
    }

    public WebElement dynamicWebElement_date(String month, String date) {
        String xpath = "//div[contains(@class,'DayPicker-Day')][contains(@aria-label,'" + month + " " + date + "')]";
        return driver.findElement(By.xpath(xpath));
    }

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectFlightTab() {
        flightTab.click();
    }

    public void selectRoundTrip() {
        roundTripOption.click();
    }

    public void enterFromCity(String fromCityName) throws InterruptedException {
        fromCity.click();
        Thread.sleep(5000);
        fromInput.sendKeys(fromCityName);
        Thread.sleep(5000);
        selectFromCityFrmDropDown.click();
    }

    public void enterToCity(String toCityName) throws InterruptedException {
        toCity.click();
        Thread.sleep(3000);
        toInput.sendKeys(toCityName);
        Thread.sleep(3000);
        selectToCityFrmDropDown.click();
    }

    public void selectDates(String date) throws InterruptedException {
        Thread.sleep(1000);
        while (true) {
            try {
                if (dynamicWebElement_monthName(date.split("-")[1]).isDisplayed() && dynamicWebElement_yearName(date.split("-")[1], date.split("-")[2]).isDisplayed()) {
                    dynamicWebElement_date(date.split("-")[1], date.split("-")[0]).click();
                    break;
                } else {
                    nextMonthNav.click();
                }
            } catch (Exception e) {
                System.out.println("Exception");
                nextMonthNav.click();
            }
        }
    }

    public void clickSearch() {
        searchButton.click();
    }

}
