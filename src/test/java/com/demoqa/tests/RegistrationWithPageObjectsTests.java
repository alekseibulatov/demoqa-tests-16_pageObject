package com.demoqa.tests;

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
        String userDayBirthDay = "03";
        String userMonthBirthDay = "March";
        String userYearBirthDay = "1981";


        registrationPage.openPage()
                .setFirstName(userName)
                .setFirstName(userName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(genderWrapper)
                .setPhoneNumber(userPhoneNumber)
                .setBirthDate(userDayBirthDay, userMonthBirthDay, userYearBirthDay);


        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("original.jpg");
        $("#currentAddress").setValue("SPb. Street ");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();
        registrationPage.verifyResultModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", genderWrapper)
                .verifyResult("Mobile", userPhoneNumber)
                .verifyResult("Date of Birth", userDayBirthDay + " " + userMonthBirthDay + "," + userYearBirthDay);
        //     .verifyResult("Subjects")
        //     .verifyResult("Hobbies")
        //     .verifyResult("Picture")
        //     .verifyResult("Address")
        //     .verifyResult("State and City");
        // $(".table-responsive").shouldHave(text("Aleksei Ivanov"), text("sdd@qaguru.ru"),
        //       text("Male"), text("7900876342"), text("03 March,1981"), text("Maths"),
        //       text("Sports"), text("original.jpg"), text("SPb. Street"), text("NCR Delhi"));
    }
}
