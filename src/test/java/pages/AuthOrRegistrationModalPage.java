package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AuthOrRegistrationModalPage {
    private SelenideElement header = $(".header.vertical-content__header .vertical-content__title", 1),
    titleConfirmPhone = $(".vertical-content__header",1),
    inputPhone = $(".input-field__input",1),
    errorMessageInvalidPhone = $("#phone-error"),
            inputSms = $("[placeholder='Код из SMS']");

    public AuthOrRegistrationModalPage assertionHeaderAuthOrRegistration(){
        header.shouldHave(text("Войти или зарегистрироваться"));
        return this;
    }

    public AuthOrRegistrationModalPage setValueInPhoneInput(String phone){
        inputPhone.val(phone);
        return this;
    }

    public AuthOrRegistrationModalPage assertErrorPhoneInvalid(){
        errorMessageInvalidPhone.shouldHave(text("Введите номер телефона полностью"));
        return this;
    }

    public AuthOrRegistrationModalPage assertTitleConfirmPhone(){
        titleConfirmPhone.shouldHave(text("Подтвердите номер"));
        return this;
    }

    public AuthOrRegistrationModalPage setConfirmCodeFromSms(String code){
        inputSms.val(code);
        return this;
    }


}
