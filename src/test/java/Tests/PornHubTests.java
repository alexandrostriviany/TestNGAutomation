package Tests;

import Pages.PornHub;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

/**
 * Created by BDSM on 08.02.2017.
 */
public class PornHubTests {

    WebDriver driver = new ChromeDriver();
    PornHub pornHub = new PornHub(driver);

    @Test
    public void searchTest1() {
        pornHub.openHomePage();
        pornHub.searchWord("ass");
        pornHub.checkPageTitle("ass");
    }

    @AfterTest
    public void afterTest() {
        pornHub.close();
    }
}
