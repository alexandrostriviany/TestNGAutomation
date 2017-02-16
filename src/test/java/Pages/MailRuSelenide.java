package Pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by Oleksandr_Mosin on 2/16/2017.
 */
public class MailRuSelenide {

    @FindBy(className = "logo__link__img logo__link__img_medium")
    private SelenideElement header;

    @FindBy(how = How.ID, using = "mailbox__login")
    private SelenideElement loginField;

    @FindBy(how = How.ID, using = "mailbox__password")
    private SelenideElement passwordField;

    @FindBy(id = "mailbox__auth__button")
    private SelenideElement enterButton;

    @FindBy(id = "mailbox__auth__remember__checkbox")
    private SelenideElement rememberMeCheckBox;


    public MailRuSelenide openMailRuHomePage() {
        open("http://mail.ru/");
        return page(MailRuSelenide.class);
    }

    public MailRuSelenide enterName(final String name) {
        loginField.setValue(name);
        return page(MailRuSelenide.class);
    }

    public void enterPassword(final String pass) {
        passwordField.setValue(pass);
    }

    public void setRememberMeCheckBox(final boolean condition) {
        rememberMeCheckBox.setSelected(condition);
    }

    public void pressEnter() {
        passwordField.pressEnter();
    }

}
