package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;


public class AuthOrRegistrationTest extends TestBase {
   private String fakeInvalidPhone = faker.numerify("###"),
           fakePhone = faker.numerify("#######"),
    fakeConfirmCode = faker.numerify("########");

    @Test
    void checkAuthOrRegistrationWithInvalidPhone(){
        mainPage.openMainPage()
                .clickProfileIcon();
        authOrRegistrationModalPage.setValueInPhoneInput("905"+fakeInvalidPhone)
                .clickGetCodeSubmitButton()
                .assertErrorPhoneInvalid();
    }

    @Test
    void checkSendMessageAfterAuthOrReg(){
        mainPage.openMainPage()
                .clickProfileIcon();
        authOrRegistrationModalPage.setValueInPhoneInput("905"+fakePhone)
                .clickGetCodeSubmitButton()
                .assertTitleConfirmPhone();
    }

    @Test
    void checkErrorMessageForSetInvalidConfirmCode(){
        mainPage.openMainPage()
                .clickProfileIcon();
        authOrRegistrationModalPage.setValueInPhoneInput("905"+fakePhone)
                .clickGetCodeSubmitButton()
                .setConfirmCodeFromSms(fakeConfirmCode)
                .clickConfirmCodeSubmitButton()
                .assertionErrorInvalidConfirmCode();
    }

    @Test
    void testRepeatSentConfirmCodeButton(){
        mainPage.openMainPage()
                .clickProfileIcon();
        authOrRegistrationModalPage.setValueInPhoneInput("905"+fakePhone)
                .clickGetCodeSubmitButton()
                .assertCounterRepeatSentCode()
                .assertVisibleRepeatButtonAfter30sec();
    }
}
