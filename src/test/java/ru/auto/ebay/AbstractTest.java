package ru.auto.ebay;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import ru.auto.ebay.ApplicationManagers.EbayManager;

/**
 * Created by Иван on 04.10.2017.
 */
public abstract class AbstractTest {
  protected static final EbayManager MANAGER = new EbayManager();

  @BeforeSuite
  public void setUp() throws Exception {
    MANAGER.init();
  }

  @AfterSuite
  public void tearDown() {
    MANAGER.stop();
  }
}
