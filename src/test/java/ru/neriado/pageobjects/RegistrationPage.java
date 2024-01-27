package ru.neriado.pageobjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import ru.neriado.pageobjects.components.CalendarComponent;
import ru.neriado.pageobjects.components.CheckModalComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    CheckModalComponent checkModalComponent = new CheckModalComponent();

    private SelenideElement firstName = $("#firstName");
    private SelenideElement lastName = $("#lastName");
    private SelenideElement email = $("#userEmail");
    private SelenideElement gender = $("[for='gender-radio-1']");
    private SelenideElement phoneNumber = $("#userNumber");
    private SelenideElement calendarInput = $("#dateOfBirthInput");
    private SelenideElement selectSubject = $("#subjectsInput");
    private SelenideElement setHobbie = $("#hobbiesWrapper");
    private SelenideElement picture = $("#uploadPicture");
    private SelenideElement adress = $("#currentAddress");
    private SelenideElement stateAndCity = $("#stateCity-wrapper");
    private SelenideElement submitButton = $("#submit");
    private SelenideElement resultForm = $(".modal-content");

    public RegistrationPage openPage() {
        open("/automation-practice-form");
        Selenide.executeJavaScript("$('#fixedban').remove()");
        Selenide.executeJavaScript("$('footer').remove()");

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstName.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastName.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        email.setValue(value);

        return this;
    }

    public RegistrationPage setGender() {
        gender.click();

        return this;
    }

    public RegistrationPage setPhoneNumber(String value) {
        phoneNumber.setValue(value);

        return this;
    }

    public RegistrationPage setDateOfBirth(String day, Integer month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        selectSubject.click();
        selectSubject.setValue(value);
        selectSubject.pressEnter();

        return this;
    }

    public RegistrationPage setHobie(String value) {
        setHobbie.$(byText(value)).click();

        return this;
    }

    public RegistrationPage uploadPicture(String value) {
        picture.uploadFromClasspath(value);

        return this;
    }

    public RegistrationPage setCurrentAdress(String value) {
        adress.setValue(value);

        return this;
    }

    public RegistrationPage setState(String value) {
        stateAndCity.$(byText("Select State")).click();
        stateAndCity.$(byText(value)).click();

        return this;
    }

    public RegistrationPage setCity(String value) {
        stateAndCity.$(byText("Select City")).click();
        stateAndCity.$(byText(value)).click();

        return this;
    }

    public RegistrationPage pressSubmit() {
        submitButton.click();

        return this;
    }

    public RegistrationPage modalWindow(String value){
        resultForm.shouldHave(text(value));

        return this;
    }

    public RegistrationPage checkResult(String key, String value) {
        checkModalComponent.checkFullFormResult(key, value);
        return this;
    }
}
