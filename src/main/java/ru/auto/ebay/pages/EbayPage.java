package ru.auto.ebay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by 05.10.2017.
 */
public class EbayPage extends AbstractPage{
    private final static String HOME_URL = "https://www.ebay.com/";
    private final static String LOGOUT_URL = "https://signin.ebay.com/ws/eBayISAPI.dll?SignIn&lgout=1";

    @FindBy(id = "gh-ac")
    private WebElement fieldSearch;

    @FindBy(id = "gh-btn")
    private WebElement buttonSearch;

    private String COUNT_ITEMS_ON_PAGE_XPATH = "//div[@id='cbBtmElem']//a[.='%s']";

    //===================================== register form ==============================================================

    @FindBy(linkText = "зарегистрируйтесь")
    private WebElement linkRegister;

    @FindBy(id = "firstname")
    private WebElement fieldFirstName;

    @FindBy(id = "lastname")
    private WebElement fieldLastName;

    @FindBy(id = "email")
    private WebElement fieldEmail;

    @FindBy(id = "PASSWORD")
    private WebElement fieldPassword;

    @FindBy(xpath = "//input[@id='ppaFormSbtBtn' and not(@disabled)]")
    private WebElement buttonRegister;

    //======================================= login form ===============================================================

    @FindBy(xpath = "//a[contains(text(),'Войдите')]")
    private WebElement linkLogin;

    @FindBy(id = "userid")
    private WebElement fieldLoginEmail;

    @FindBy(id = "pass")
    private WebElement fieldLoginPassword;

    @FindBy(id = "sgnBt")
    private WebElement buttonAuthorize;

    @FindBy(xpath = "//a[contains(text(),'Возможно позже')]")
    private WebElement linkAskLater;

    //==================================================================================================================

    public EbayPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public EbayPage openHomePage() {
        open(HOME_URL);
        return this;
    }

    public EbayPage fillRegistryForm(String firstname, String lastname, String email, String password) {
        click(linkRegister);
        type(fieldFirstName, firstname);
        type(fieldLastName, lastname);
        type(fieldEmail, email);
        type(fieldPassword, password);
        click(buttonRegister);
        return this;
    }

    public EbayPage login(String email, String password) {
        if (linkLogin.isEnabled()) {
            click(linkLogin);
            type(fieldLoginEmail, email);
            type(fieldLoginPassword, password);
            click(buttonAuthorize);
            if (find(By.id("gh-ac")).isEnabled()) {
                click(By.id("gh-la"));
            } else {
                click(linkAskLater);
            }
        }
        return this;
    }

    public EbayPage search(String searchText) {
        type(fieldSearch, searchText);
        click(buttonSearch);
        return this;
    }

    public EbayPage checkCountItemsOnPage(int count) {
        Assert.assertTrue(find(By.xpath(String.format(COUNT_ITEMS_ON_PAGE_XPATH, count))).isDisplayed());
        return this;
    }

    public EbayPage logout() {
        open(LOGOUT_URL);
        Assert.assertTrue(find(By.xpath("//span[contains(text(),'Выход успешно выполнен. До скорой встречи.')]"))
                .isDisplayed());
        return this;
    }
}
