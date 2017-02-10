package Pages;

import com.sun.org.glassfish.external.probe.provider.annotations.ProbeListener;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * Created by BDSM on 08.02.2017.
 */
public class PornHub extends Helper{

    WebDriver driver;

    public PornHub(WebDriver driver) {
        this.driver = driver;
    }

    private static String homePage = "http://pornhub.com";

    By searchField = By.id("searchInput");
    By searchPageTitle = By.className("searchPageTitle");
    By btnSearch = By.id("btnSearch");

    public void openHomePage() {
        driver.get(homePage);
    }

    public void searchWord(final String word) {
        driver.findElement(searchField).sendKeys(word);
        driver.findElement(btnSearch).click();
    }

    public void checkPageTitle(final String expected) {
        WebElement actual = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(searchPageTitle));
        Assert.assertEquals(actual.getText(), "Most Relevant Video Results: \"" + expected + "\"");
    }

    public void close() {
        driver.quit();
    }
}
