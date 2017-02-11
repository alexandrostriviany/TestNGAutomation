package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import static java.lang.Thread.sleep;

/**
 * Created by BDSM on 11.02.2017.
 */
public class YandexMusicGenre extends Helper {

    WebDriver driver;

    public YandexMusicGenre (WebDriver driver) {
        this.driver = driver;
    }

    private static String genrePage = "https://music.yandex.ua/genre/all";

    By genreTitle = By.xpath("//*[@class=\"subhead\"]//*[@class=\"page-genre__title\"]");

    public void openGenrePage() {
        driver.get(genrePage);
    }

    public void chooseGenre(final String genre){
        String value = genre;
        WebElement element = driver.findElement(By.linkText(value));
        element.click();
    }

    public void checkGenreTitle(final String genre){
        WebElement title = driver.findElement(genreTitle);
        scrollToElement(driver,title);
        String actual = title.getText();
        Assert.assertEquals(actual,genre);
    }

}
