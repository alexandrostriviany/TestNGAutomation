import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by BDSM on 05.02.2017.
 */
public class Driver {
    void installDriver(){
        System.setProperty("webdriver.chrome.driver", "/driver/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
    }
}
