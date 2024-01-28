package ru.neriado.pageobjects.components;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckModalComponent {

    public void checkFullFormResult(String key, String value){
        $(".modal-body").$(byText(key)).parent()
                .shouldHave(text(value));
    }

    public void negativeFormCheck() {
        $(".modal-content").shouldNot(appear);

    }
}
