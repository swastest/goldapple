package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AuthOrRegistrationModalPage {
    private SelenideElement header = $("header.vertical-content__header .vertical-content__title", 1),
            titleConfirmPhone = $(".vertical-content__header", 2),
            inputPhone = $(".input-field__input", 2),
            errorMessageInvalidPhone = $("#phone-error"),
            inputSms = $("[placeholder='Код из SMS']"),
            buttonGetCode = $(".vertical-content__actions", 1).lastChild(),
            buttonConfirmCode = $(".vertical-content__actions", 2).lastChild(),
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

    public AuthOrRegistrationModalPage clickGetCodeSubmitButton() {
        buttonGetCode.click();
        return this;
    }

    public AuthOrRegistrationModalPage clickConfirmCodeSubmitButton() {
        buttonConfirmCode.click();
        return this;
    }

    public AuthOrRegistrationModalPage setConfirmCodeFromSms(String code) {
        inputSms.val(code);
        return this;
    }

    public AuthOrRegistrationModalPage assertionErrorInvalidConfirmCode() {
        errorMessageInvalidConfirmCode.shouldHave(text("введённый код неверен"));
        return this;
    }

    public AuthOrRegistrationModalPage assertCounterRepeatSentCode(){
        counterRepeatSentCode.shouldHave(text("код отправлен, запросить повторный можно через"));
        return this;
    }

    public AuthOrRegistrationModalPage assertVisibleRepeatButtonAfter30sec(){
        repeatSentCode.shouldBe(Condition.text("Отправить код повторно"), Duration.ofSeconds(30));
        return this;
    }
}
