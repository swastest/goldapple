package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private SelenideElement buttonAddCard = $(".pdp-form__buttons .button-primary_add-to-cart"),
    buttonAddWishlist = $(".pdp-form__buttons .button-primary_favorite"),
    cardCount = $("span.counter-number");

    public ProductPage clickAddCard(){
        buttonAddCard.click();
        return this;
    }

    public ProductPage assertionAddedProductToCard(){
        cardCount.shouldHave(text("1"));
        return this;
    }

    public ProductPage clickAddToWishlist(){
        buttonAddWishlist.click();
        return this;
    }

}
