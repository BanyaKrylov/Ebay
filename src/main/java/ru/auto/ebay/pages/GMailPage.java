package ru.auto.ebay.pages;

import com.sun.istack.internal.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by 05.10.2017.
 */
public class GMailPage extends AbstractPage {
    private final static String HOME_URL = "https://www.gmail.com/";

    @FindBy(xpath = "//input[@id='identifierId']")
    private WebElement fieldEmail;

    @FindBy(xpath = "//span[contains(text(),'Далее')]")
    private WebElement buttonNext;

    @FindBy(xpath = "//div[@id='password']/div[1]/div/div[1]/input")
    private WebElement fieldPassword;

    private String LINK_MAILWITH_TITLE_XPATH = "//span/b[contains(text(),'%s')]";

    @FindBy(xpath = "//span[contains(text(),'Перейти к покупкам')]")
    private WebElement linkGoToShop;

    public GMailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GMailPage openHomePage() {
        open(HOME_URL);
        return this;
    }

    public GMailPage login(String email, String password) {
        type(fieldEmail, email);
        click(buttonNext);
        waitFor(1000);
        type(fieldPassword, password);
        click(buttonNext);
        return this;
    }

    public GMailPage openMailWithTitle(@NotNull String title) {
        //По данному локатору находится именно непрочитанное письмо
        click(By.xpath(String.format(LINK_MAILWITH_TITLE_XPATH, title)));
        return this;
    }

    public EbayPage confirm() {
        //Ссылки для подтверждения почтового адреса в письме не найдено, поэтому нажимаю то, что есть
        click(linkGoToShop);
        closeTabOrWindowWithIndex(0);
        return new EbayPage(driver);
    }
}
