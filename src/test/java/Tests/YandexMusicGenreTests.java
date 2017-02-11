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
public class YandexMusicGenreTests {

    WebDriver driver = new ChromeDriver();
    YandexMusicGenre yandexMusicGenre = new YandexMusicGenre(driver);

    @DataProvider(name = "genre")
    public static Object[][] values() {
        return new Object[][]{{"Рок"},{"R&B"}};
    }


    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/Chrome/chromedriver.exe");
        driver = new ChromeDriver();
        yandexMusicGenre = new YandexMusicGenre(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
    }

    @Test(dataProvider = "genre")
    public void searchTest1(String value) {
        yandexMusicGenre.openGenrePage();
        yandexMusicGenre.chooseGenre(value);
        yandexMusicGenre.checkGenreTitle(value);
    }

    @AfterTest
    public void afterTest() {
        yandexMusicGenre.close(driver);
    }
}
