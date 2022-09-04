package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthOrRegistrationTest extends TestBase {
    private String fakeInvalidPhone = faker.numerify("###"),
            fakePhone = faker.numerify("#######"),
            fakeConfirmCode = faker.numerify("########");

    @Test
    @DisplayName("Проверка сообщения об ошибке при введении невалидного номера телефона")
    void checkAuthOrRegistrationWithInvalidPhone() {
        mainPage.openMainPage()
                .clickProfileIcon();
        authOrRegistrationModalPage.setValueInPhoneInput("905" + fakeInvalidPhone)
                .clickGetCodeSubmitButton()
                .assertErrorPhoneInvalid();
    }

    @Test
    @DisplayName("После введения номера телефона отправляется Смс-сообщение с кодом подтверждения")
    void checkSendMessageAfterAuthOrReg() {
        mainPage.openMainPage()
                .clickProfileIcon();
        authOrRegistrationModalPage.setValueInPhoneInput("905" + fakePhone)
                .clickGetCodeSubmitButton()
                .assertTitleConfirmPhone();
    }

    @Test
    @DisplayName("При неправильно введенном коде подтверждения телефона отображается сообщение об ошибке")
    void checkErrorMessageForSetInvalidConfirmCode() {
        mainPage.openMainPage()
                .clickProfileIcon();
        authOrRegistrationModalPage.setValueInPhoneInput("905" + fakePhone)
                .clickGetCodeSubmitButton()
                .setConfirmCodeFromSms(fakeConfirmCode)
                .clickConfirmCodeSubmitButton()
                .assertionErrorInvalidConfirmCode();
    }

    @Test
    @DisplayName("Спустя 30 сек. после отправки первого Смс с кодом, можно запросить повторную отправку")
    void testRepeatSentConfirmCodeButton() {
        mainPage.openMainPage()
                .clickProfileIcon();
        authOrRegistrationModalPage.setValueInPhoneInput("905" + fakePhone)
                .clickGetCodeSubmitButton()
                .assertCounterRepeatSentCode()
                .assertVisibleRepeatButtonAfter30sec();
    }
}
