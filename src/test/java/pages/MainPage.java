package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private SelenideElement firstProductSlide = $(".product-slider__item ");

    public MainPage openMainPage(){
        open("");
        return this;
    }

    public MainPage clickOnFirstProduct(){
        firstProductSlide.click();
        return this;
    }


}
