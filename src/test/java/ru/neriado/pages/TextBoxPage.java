package ru.neriado.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {

    private SelenideElement
            setUserName = $("#userName"),
            setUserEmail = $("#userEmail"),
            setCurrentAdress = $("#currentAddress"),
            setPermanentAdress = $("#permanentAddress"),
            submitButton = $("#submit"),
            outputInfo = $("#output");

    public TextBoxPage openTextBoxPage() {
        open("/text-box");

        return this;
    }


    public TextBoxPage setSetUserName(String value) {
        setUserName.setValue(value);

        return this;
    }

    public TextBoxPage setSetUserEmail(String value) {
        setUserEmail.setValue(value);

        return this;
    }

    public TextBoxPage setCurrentAdress(String value) {
        setCurrentAdress.setValue(value);

        return this;
    }

    public TextBoxPage setPermanentAdress(String value) {
        setPermanentAdress.setValue(value);

        return this;
    }

    public TextBoxPage pushSubmitButton() {
        submitButton.click();

        return this;
    }

    public TextBoxPage chekOutputInfo(String key, String value) {
        outputInfo.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
}

