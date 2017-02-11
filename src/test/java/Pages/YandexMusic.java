package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

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
    By singerNameOnList = By.xpath("//*[@class = \"track track_type_full track_selectable\"]//*[@class=\"track__artists nw\"]");
    By singerNameOnControlPanel = By.xpath("//*[@class = \"player-controls\"]//*[@class=\"track__artists\"]");
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
        scrollToElement(driver, driver.findElements(songsList).get(2));
        list.get(3).click();
    }

    public void checkSingerOnPlayerControl(String singer){
        String expected = singer.toLowerCase();
        String actual = driver.findElement(singerNameOnControlPanel).getText().toLowerCase();
        Assert.assertEquals(actual,singer);
    }

}