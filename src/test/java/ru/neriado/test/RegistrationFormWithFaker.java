package ru.neriado.test;

import org.junit.jupiter.api.Test;
import ru.neriado.pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.sleep;

public class RegistrationFormWithFaker extends TestBase{
    RegistrationPage registrationPage = new RegistrationPage();

    TestData testData = new TestData();

    @Test
    void demoqaFullFormWebTestWithFaker() {


        registrationPage.openPage()
                .closeBanner()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setPhoneNumber(testData.phoneNumber)
                .setDateOfBirth(testData.dayOfBirth, testData.monthOfBirth, testData.yearOfBirth)
                .setSubject(testData.setSubject)
                .setHobie(testData.setHobbies)
                .uploadPicture(testData.photo)
                .setCurrentAdress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .pressSubmit()
                .modalWindow(testData.modalHead)
                .checkResult("Student Name", testData.firstName + " "+ testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phoneNumber)
                .checkResult("Date of Birth", testData.dayOfBirth + " " + testData.monthOfBirth + ","
                        + testData.yearOfBirth)
                .checkResult("Subjects", testData.setSubject)
                .checkResult("Hobbies", testData.setHobbies)
                .checkResult("Picture", testData.photo)
                .checkResult("Address", testData.address)
                .checkResult("State and City", testData.state + " " + testData.city);


    }
}
