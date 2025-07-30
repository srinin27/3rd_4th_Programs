package CommonLib;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;


public class appLibrary {

    public static void wait(WebDriver driver, WebElement ele, int seconds) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(seconds))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(ele));
    }

    public static String customXpath(String xpath, Objects... args) {
        for (int i = 0; i < args.length; i++) {
            xpath = xpath.replace("{" + i + "}", args[i].toString());
        }
        return xpath;
    }
}
