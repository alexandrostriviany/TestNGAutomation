package Tests;

import Pages.YandexMusic;
import Pages.YandexMusicGenre;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * Created by Oleksandr_Mosin on 2/9/2017.
 */
public class YandexMusicTests {

    WebDriver driver;
    YandexMusic yandexMusic;

    @DataProvider(name = "singers")
    public static Object[][] values() {
        return new Object[][]{{"guano apes"},{"хлеб"}};
    }


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        yandexMusic = new YandexMusic(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    @Test (dataProvider = "singers")
    public void searchTest1(String sSinger) {
        yandexMusic.openHomePage();
        yandexMusic.searchWord(sSinger);
        yandexMusic.playSong();
        yandexMusic.checkSingerOnPlayerControl(sSinger);
    }

    @AfterTest
    public void afterTest() {
        yandexMusic.close(driver);
    }
}
