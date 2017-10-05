package ru.auto.ebay;

import org.testng.annotations.Test;
import ru.auto.ebay.pages.EbayPage;

import java.io.IOException;

public class SearchTests extends AbstractTest {

  //Данные авторизации GMAIL
  String email = "ttestov810@gmail.com";
  String password = "123456qWeRtY";
  String firstname = "user";
  String lastname = "name";
  String searchText = "blackberry";
  int counnItemsOnPage = 50;

  @Test
  public void Search() throws IOException, InterruptedException {
    MANAGER.search().openEbayHomePage()
            .fillRegistryForm(firstname, lastname, email, password);

    EbayPage ebayPage = MANAGER.search().openGMailHomePage()
            .login(email, password)
            .openMailWithTitle("Добро пожаловать на eBay!")
            .confirm();

    ebayPage.login(email, password)
            .search(searchText)
            .checkCountItemsOnPage(counnItemsOnPage)
            .logout();
  }
}
