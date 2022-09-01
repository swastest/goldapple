package tests;

import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.ProductPage;

public class UsersAddProductTest extends TestBase{

    @Test
    void userAddCardFirstProductFromMainPage(){
        new MainPage().openMainPage()
                .clickOnFirstProduct();
        new ProductPage().clickAddCard()
                .assertionAddedProductToCard();
    }
}
