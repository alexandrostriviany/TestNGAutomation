package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * Created by BDSM on 08.02.2017.
 */
public class YandexMusic {

    WebDriver driver;

    public YandexMusic(WebDriver driver) {
        this.driver = driver;
    }

    private static String homePage = "http://music.yandex.ua/";

    static By searchField = By.id("nb-2");
    static By searchPageTitle = By.className("srg");
    static By btnSearch = By.xpath("//button[@type =\"submit\"]");

    public void openHomePage() {
        driver.get(homePage);
    }

    public void searchWord(final String word) {
        driver.findElement(searchField).sendKeys(word);
        driver.findElement(btnSearch).click();
    }

    public void close() {
        driver.quit();
    }
}