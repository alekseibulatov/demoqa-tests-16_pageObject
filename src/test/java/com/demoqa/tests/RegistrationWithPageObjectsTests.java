package com.demoqa.tests;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationWithPageObjectsTests extends TestBase {
    @Test
    void successRegistration() {
        String userName = "Aleksei";
        String lastName = "Ivanov";
        String userEmail = "sdd@qaguru.ru";
        String genderWrapper = "Male";
        String userPhoneNumber = "79008763421";

        registrationPage.openPage()
                .setFirstName(userName)
                .setFirstName(userName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(genderWrapper)
                .setPhoneNumber(userPhoneNumber);


        $("#dateOfBirthInput").click();
        $(".react-datepicker").shouldBe(Condition.visible);
        $(".react-datepicker__year-select").click();
        $(".react-datepicker__year-select").selectOption("1981");
        $(".react-datepicker__month-select").click();
        $(".react-datepicker__month-select").selectOption("March");
        $(".react-datepicker__day--003:not(.react-datepicker__day--outside-month)").click();
        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("original.jpg");
        $("#currentAddress").setValue("SPb. Street ");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Aleksei Ivanov"), text("sdd@qaguru.ru"),
                text("Male"), text("7900876342"), text("03 March,1981"), text("Maths"),
                text("Sports"), text("original.jpg"), text("SPb. Street"), text("NCR Delhi"));
    }
}
