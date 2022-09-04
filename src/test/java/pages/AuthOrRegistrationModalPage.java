package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AuthOrRegistrationModalPage {
    private SelenideElement header = $("header.vertical-content__header .vertical-content__title", 1),
            titleConfirmPhone = $(".vertical-content__header", 1),
            inputPhone = $(".input-field__input", 2),
            errorMessageInvalidPhone = $("#phone-error"),
            inputSms = $("[placeholder='Код из SMS']"),
            buttonGetCode = $(".vertical-content__actions", 0).lastChild(),
            buttonConfirmCode = $(".vertical-content__actions", 1).lastChild(),
            errorMessageInvalidConfirmCode = $("label._ogg-error"),
            counterRepeatSentCode = $(".input-field__descriptor"),
            repeatSentCode = $(".link.vertical-content__action-link");

    @Step("Проверка заголовка модального окна, что текст соответствует 'Войти или зарегистрироваться'")
    public AuthOrRegistrationModalPage assertionHeaderAuthOrRegistration() {
        header.shouldHave(text("Войти или зарегистрироваться"));
        return this;
    }

    @Step("Ввести номер телефона")
    public AuthOrRegistrationModalPage setValueInPhoneInput(String phone) {
        inputPhone.val(phone);
        return this;
    }

    @Step("Проверка сообщения об ошибке при введенном невалидном телефоне, текст ошибки соответствует тексту 'Введите номер телефона полностью'")
    public AuthOrRegistrationModalPage assertErrorPhoneInvalid() {
        errorMessageInvalidPhone.shouldHave(text("Введите номер телефона полностью"));
        return this;
    }

    @Step("Проверка наименования формы Подтверждения номера")
    public AuthOrRegistrationModalPage assertTitleConfirmPhone() {
        titleConfirmPhone.shouldHave(text("Подтвердите номер"));
        return this;
    }

    @Step("Нажать на кнопку получить код из Смс")
    public AuthOrRegistrationModalPage clickGetCodeSubmitButton() {
        buttonGetCode.click();
        return this;
    }

    @Step("Нажать на кнопку Подтвердить телефон")
    public AuthOrRegistrationModalPage clickConfirmCodeSubmitButton() {
        buttonConfirmCode.click();
        return this;
    }

    @Step("Ввести код из смс")
    public AuthOrRegistrationModalPage setConfirmCodeFromSms(String code) {
        inputSms.val(code);
        return this;
    }

    @Step("Проверка ошибки при неверно введенном коде из Смс")
    public AuthOrRegistrationModalPage assertionErrorInvalidConfirmCode() {
        errorMessageInvalidConfirmCode.shouldHave(text("введённый код неверен"));
        return this;
    }

    @Step("Проверка сообщения о том что код отправлен и может быть запрошен повторно")
    public AuthOrRegistrationModalPage assertCounterRepeatSentCode() {
        counterRepeatSentCode.shouldHave(text("код отправлен, запросить повторный можно через"));
        return this;
    }

    @Step("Проверка кнопки повторной отправки кода подтверждения в Смс")
    public AuthOrRegistrationModalPage assertVisibleRepeatButtonAfter30sec() {
        repeatSentCode.shouldBe(Condition.text("Отправить код повторно"), Duration.ofSeconds(30));
        return this;
    }
}