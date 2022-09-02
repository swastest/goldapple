package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private SelenideElement buttonAddCard = $(".pdp-form__buttons .button-primary_add-to-cart"),
    buttonAddWishlist = $(".pdp-form__buttons .button-primary_favorite"),
    cardCount = $("span.counter-number");

    @Step("Нажать на кнопку добавления товара в корзину")
    public ProductPage clickAddCard(){
        buttonAddCard.click();
        return this;
    }

    @Step("Проверка количества добавленных продуктов в корзине")
    public ProductPage assertionAddedProductToCard(){
        cardCount.shouldHave(text("1"));
        return this;
    }

    @Step("Нажать на кнопку добавить в Избранное")
    public ProductPage clickAddToWishlist(){
        buttonAddWishlist.click();
        return this;
    }

}
