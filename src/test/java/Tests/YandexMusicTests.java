package Tests;

import Pages.YandexMusic;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/**
 * Created by Oleksandr_Mosin on 2/9/2017.
 */
public class YandexMusicTests {

    WebDriver driver;
    YandexMusic yandexMusic;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        yandexMusic = new YandexMusic(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    @Test
    public void searchTest1() {
        yandexMusic.openHomePage();
        yandexMusic.searchWord("eminem");
        yandexMusic.playSong();
    }

    @AfterTest
    public void afterTest() {
        yandexMusic.close();
    }
}
