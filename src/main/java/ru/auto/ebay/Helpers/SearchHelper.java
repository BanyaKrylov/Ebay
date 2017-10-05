package ru.auto.ebay.Helpers;

import org.openqa.selenium.WebDriver;
import ru.auto.ebay.pages.EbayPage;
import ru.auto.ebay.pages.GMailPage;

/**
 * Created by Иван on 04.10.2017.
 */
public class SearchHelper {
  private EbayPage ebayPage;
  private GMailPage gMailPage;

  public SearchHelper(WebDriver wd) {
    ebayPage = new EbayPage(wd);
    gMailPage = new GMailPage(wd);
  }

  public EbayPage openEbayHomePage() {
    return ebayPage.openHomePage();
  }

  public GMailPage openGMailHomePage() {
    return gMailPage.openHomePage();
  }
}
