package com.demoqa.tests;

import org.junit.jupiter.api.*;


public class RegistrationWithPageObjectsTests extends TestBase {
    @Test
    void successRegistration() {
        String userName = "Aleksei";
        String lastName = "Ivanov";
        String userEmail = "sdd@qaguru.ru";
        String genderWrapper = "Male";
        String userPhoneNumber = "7900876342";
        String userDayBirthDay = "03";
        String userMonthBirthDay = "March";
        String userYearBirthDay = "1981";
        String userSubjects = "Math";
        String userHobbies = "Sports";
        String userPictureName = "original.jpg";
        String userAddress = "SPb. Street ";
        String userState = "NCR";
        String userCity = "Delhi";

        registrationPage.openPage()
                .setFirstName(userName)
                .setFirstName(userName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(genderWrapper)
                .setPhoneNumber(userPhoneNumber)
                .setBirthDate(userDayBirthDay, userMonthBirthDay, userYearBirthDay)
                .setSubjectsInput(userSubjects)
                .setHobbies(userHobbies)
                .loadPicture(userPictureName)
                .setCurrentAddress(userAddress)
                .setStateAndCity(userState, userCity)
                .clickButtonSubmit();

        registrationPage.verifyResultModalAppears()
                .verifyResult("Student Name", userName + " " + lastName)
                .verifyResult("Student Email", userEmail)
                .verifyResult("Gender", genderWrapper)
                .verifyResult("Mobile", userPhoneNumber)
                .verifyResult("Date of Birth", userDayBirthDay + " " + userMonthBirthDay + "," + userYearBirthDay)
                .verifyResult("Subjects", userSubjects)
                .verifyResult("Hobbies", userHobbies)
                .verifyResult("Picture", userPictureName)
                .verifyResult("Address", userAddress)
                .verifyResult("State and City", userState + " " + userCity);
    }
}
