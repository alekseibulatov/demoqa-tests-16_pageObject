package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final String TITLE_TEXT = "Practice Form";

    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            userGender = $("#genterWrapper"),
            userPhoneNumber = $("#userNumber");

    public void openPage() {
        open("/automation-practice-form");
        $(".main-header").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public void setFirstName(String value) {
        firstNameInput.setValue(value);
    }

    public void setLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void setUserEmail(String value) {
        userEmailInput.setValue(value);
    }

    public void setGender(String value) {
        userGender.$(byText(value)).click();
    }

    public void setPhoneNumber(String value) {
        userPhoneNumber.setValue(value);
    }
}
