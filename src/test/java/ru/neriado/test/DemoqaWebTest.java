package ru.neriado.test;


import org.junit.jupiter.api.Test;
import ru.neriado.pageobjects.RegistrationPage;

public class DemoqaWebTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();


    @Test
    void demoqaFullFormWebTest() {

        registrationPage.openPage()
                .setFirstName("Alan")
                .setLastName("Wake")
                .setEmail("AlWake@mail.com")
                .setGender()
                .setPhoneNumber("8975461258")
                .setDateOfBirth("17", 4, "1990")
                .setSubject("Arts")
                .setHobie("Reading")
                .uploadPicture("Rattus.jpg")
                .setCurrentAdress("some text for this object")
                .setState("Rajasthan")
                .setCity("Jaiselmer")
                .pressSubmit()
                .modalWindow("Thanks for submitting the form")
                .checkResult("Student Name", "Alan Wake")
                .checkResult("Student Email", "AlWake@mail.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8975461258")
                .checkResult("Date of Birth", "17 May,1990")
                .checkResult("Subjects", "Arts")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "Rattus.jpg")
                .checkResult("Address", "some text for this object")
                .checkResult("State and City", "Rajasthan Jaiselmer");
    }
}
