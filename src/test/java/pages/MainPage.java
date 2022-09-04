package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {
    private SelenideElement firstProductSlide = $(".product-slider__item "),
            profileIcon = $(".header-customer-icon");

    @Step("Открыть главную страницу")
    public MainPage openMainPage() {
        open("");
        return this;
    }

    @Step("Нажать на первый продукт из слайд-каталога")
    public MainPage clickOnFirstProduct() {
        firstProductSlide.click();
        return this;
    }

    @Step("Нажать на иконку Профиль")
    public MainPage clickProfileIcon() {
        profileIcon.click();
        return this;
    }
}
