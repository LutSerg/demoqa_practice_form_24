package ru.neriado.test;

import org.junit.jupiter.api.Test;
import ru.neriado.pages.TextBoxPage;

public class TextBoxTest extends TestBase {

    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void textBoxTest() {
        textBoxPage.openTextBoxPage()
                .setSetUserName("Alex Smirnoff")
                .setSetUserEmail("testemailadress@mail.qwe")
                .setCurrentAdress("some text for some address")
                .setPermanentAdress("address where you live")
                .pushSubmitButton()
                .chekOutputInfo("Name:", "Alex Smirnoff")
                .chekOutputInfo("Email:", "testemailadress@mail.qwe")
                .chekOutputInfo("Current Address :", "some text for some address")
                .chekOutputInfo("Permananet Address :", "address where you live");
    }
}
