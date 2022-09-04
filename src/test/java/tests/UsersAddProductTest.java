package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UsersAddProductTest extends TestBase{

    @Test
    @DisplayName("Добавление товара в корзину")
    void userAddCardFirstProductFromMainPage(){
        mainPage.openMainPage()
                .clickOnFirstProduct();
        productPage.clickAddCard()
                .assertionAddedProductToCard();
    }

    @Test
    @DisplayName("При добавлении товара в Избранное, для неавторизованного пользователя, отображается форма авторизации")
    void addedToWishlistUnauthorizedUser(){
        mainPage.openMainPage()
                .clickOnFirstProduct();
        productPage.clickAddToWishlist();
        authOrRegistrationModalPage.assertionHeaderAuthOrRegistration();


    }
}
