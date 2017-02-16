package Tests;

import Pages.MailRuSelenide;
import Pages.YandexMusic;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by Oleksandr_Mosin on 2/16/2017.
 */
public class SelenideTest {
    // -ea   -Dselenide.browser=org.openqa.selenium.chrome.ChromeDriver  -Dselenide.browser=org.openqa.selenium.firefox.FirefoxDriver
    MailRuSelenide mailRuSelenide = page(MailRuSelenide.class);


    @Test
    public void userCanLoginByUsername() {
        mailRuSelenide.openMailRuHomePage();
        mailRuSelenide.enterName("name");
        mailRuSelenide.enterPassword("password");
        mailRuSelenide.setRememberMeCheckBox(false);
        mailRuSelenide.pressEnter();
        Selenide.sleep(5000);
    }
}
