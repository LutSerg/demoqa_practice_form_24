package ru.neriado.test;


import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaWebTest extends TestBase {


    @Test
    void demoqaWebTest() {

        open("/automation-practice-form");

        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        $("#firstName").setValue("Alan");
        $("#lastName").setValue("Wake");
        $("#userEmail").setValue("AlWake@mail.com");
        $("[for='gender-radio-1']").click();
        $("#userNumber").setValue("8975461258");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(4);
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--017").click();
        $("#subjectsInput").click();
        $("#subjectsInput").setValue("Arts").pressEnter();
        $("#hobbiesWrapper").$(byText("Reading")).click();
        $("#uploadPicture").uploadFromClasspath("Rattus.jpg");
        $("#currentAddress").setValue("some text for this object");
        $("#stateCity-wrapper").$(byText("Select State")).click();
        $("#stateCity-wrapper").$(byText("Rajasthan")).click();
        $("#stateCity-wrapper").$(byText("Select City")).click();
        $("#stateCity-wrapper").$(byText("Jaiselmer")).click();
        $("#submit").click();
        $(".modal-content").shouldHave(text("Thanks for submitting the form"));
        $(".modal-body").$(byText("Student Name")).parent()
                .shouldHave(text("Alan Wake"));
        $(".modal-body").$(byText("Student Email")).parent()
                .shouldHave(text("AlWake@mail.com"));
        $(".modal-body").$(byText("Gender")).parent()
                .shouldHave(text("Male"));
        $(".modal-body").$(byText("Mobile")).parent()
                .shouldHave(text("8975461258"));
        $(".modal-body").$(byText("Date of Birth")).parent()
                .shouldHave(text("17 May,1990"));
        $(".modal-body").$(byText("Subjects")).parent()
                .shouldHave(text("Arts"));
        $(".modal-body").$(byText("Hobbies")).parent()
                .shouldHave(text("Reading"));
        $(".modal-body").$(byText("Picture")).parent()
                .shouldHave(text("Rattus.jpg"));
        $(".modal-body").$(byText("Address")).parent()
                .shouldHave(text("some text for this object"));
        $(".modal-body").$(byText("State and City")).parent()
                .shouldHave(text("Rajasthan Jaiselmer"));
    }
}
