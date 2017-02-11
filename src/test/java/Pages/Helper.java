package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by Oleksandr_Mosin on 2/10/2017.
 */
public class Helper {
    public void scrollWithOffset(WebDriver driver, WebElement webElement, int x, int y) {
        String code = "window.scroll(" + (webElement.getLocation().x + x) + "," + (webElement.getLocation().y + y)
                + ");";
        ((JavascriptExecutor) driver).executeScript(code, webElement, x, y);

    }

    public void scrollToElement(WebDriver driver, WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();"
                ,element);
    }

    public void close(WebDriver driver) {
        driver.quit();
    }
}
