import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by BDSM on 04.02.2017.
 */
public class SecondTest extends Driver {


    @Test
    public void webTesting(){
        System.setProperty("webdriver.chrome.driver", "/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://qa-helper.com/first_selenium_test/");
        Assert.assertEquals("qa-helper",driver.findElement(By.id("site-title")).getText());
        driver.close();
    }
}
