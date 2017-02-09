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
public class YandexMusic {

    WebDriver driver;

    public YandexMusic(WebDriver driver) {
        this.driver = driver;
    }

    private static String homePage = "http://music.yandex.ua/";

    static By searchField = By.id("nb-2");
    static By searchPageTitle = By.className("srg");
    static By btnSearch = By.xpath("//button[@type =\"submit\"]");
    By songsList = By.xpath("//*[@class = \"track track_type_full track_selectable\"]");
    By sidebarPlay = By
            .xpath("//*[@id=\"nb-1\"]//*[@class=\"sidebar-track__controls\"]//*[@class=\"icon icon_pp icon_size_L\"]");
    By trackHeader = By.xpath("//*[@class = \"link link_arrow\"]");

    public void openHomePage() {
        driver.get(homePage);
    }

    public void searchWord(final String word) {
        driver.findElement(searchField).sendKeys(word);
        driver.findElement(btnSearch).click();
    }

    public void playSong() {
        scrollWithOffset(driver.findElement(searchField), 0, 1000);
        WebElement actual = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(trackHeader));
        List<WebElement> list = driver.findElements(songsList);
        list.get(0).click();
        WebElement play = new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(sidebarPlay));
        play.click();
    }

    public void scrollWithOffset(WebElement webElement, int x, int y) {
        String code = "window.scroll(" + (webElement.getLocation().x + x) + "," + (webElement.getLocation().y + y)
                + ");";
        ((JavascriptExecutor) driver).executeScript(code, webElement, x, y);

    }

    public void close() {
        driver.quit();
    }
}