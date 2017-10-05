package ru.auto.ebay.ApplicationManagers;

import ru.auto.ebay.Helpers.SearchHelper;
import static ru.auto.ebay.driver.DriverManager.*;

/**
 * Created by Иван on 04.10.2017.
 */
public class EbayManager {
  private SearchHelper searchHelper;

  public void init() {
    searchHelper = new SearchHelper(driver());
  }

  public void stop() {
    quit();
  }

  public SearchHelper search() {
    return searchHelper;
  }
}
