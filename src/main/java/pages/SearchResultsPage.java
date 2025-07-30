package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchResultsPage {

    WebDriver driver;

    @FindBy(xpath = "//*[contains(text(),'Flights from')]")
    WebElement searchResultText;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isSearchResultDisplayed() {
        return searchResultText.isDisplayed();
    }
}
