package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * Created by BDSM on 08.02.2017.
 */
public class Google {
    static WebDriver driver = new ChromeDriver();

    private static String homePage = "http://google.com";

    static By searchField = By.id("lst-ib");
    static By searchPageTitle = By.className("srg");
    static By btnSearch = By.id("btnSearch");

    @Test
    public static void testOne(){
        driver.get(homePage);
        driver.findElement(searchField).sendKeys("asian");
        driver.findElement(searchField).submit();
        //String actual = driver.findElements(searchPageTitle).get(0).getText();
         // Assert.assertEquals("Most Relevant Video Results: \"asian\"", actual);;
    }

    @AfterTest
    public static void close(){
        driver.close();
    }
}
