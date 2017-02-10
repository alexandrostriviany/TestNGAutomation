package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by BDSM on 08.02.2017.
 */
public class YandexMusic extends Helper {

    WebDriver driver;

    public YandexMusic(WebDriver driver) {
        this.driver = driver;
    }

    private static String homePage = "http://music.yandex.ua/";

    By searchField = By.id("nb-2");
    By btnSearch = By.xpath("//button[@type =\"submit\"]");
    By songsList = By.xpath("//*[@class = \"track track_type_full track_selectable\"]//*[@class=\"track__cover\"]");
    By sidebarPlay = By
            .xpath("//*[@id=\"nb-1\"]//*[@class=\"sidebar-track__controls\"]//*[@class=\"icon icon_pp icon_size_L\"]");


    public void openHomePage() {
        driver.get(homePage);
    }

    public void searchWord(final String word) {
        driver.findElement(searchField).sendKeys(word);
        driver.findElement(btnSearch).click();
    }

    public void playSong() {
        List<WebElement> list = driver.findElements(songsList);
        scrollToElement(driver, driver.findElements(songsList).get(3));
        list.get(4).click();
    }

    public void close() {
        driver.quit();
    }
}