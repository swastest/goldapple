package tests;

import org.junit.jupiter.api.Test;

public class UsersAddProductTest extends TestBase{

    @Test
    void userAddCardFirstProductFromMainPage(){
        mainPage.openMainPage()
                .clickOnFirstProduct();
        productPage.clickAddCard()
                .assertionAddedProductToCard();
    }

    @Test
    void addedToWishlistUnauthorizedUser(){
        mainPage.openMainPage()
                .clickOnFirstProduct();
        productPage.clickAddToWishlist();
        authOrRegistrationModalPage.assertionHeaderAuthOrRegistration();


    }
}
