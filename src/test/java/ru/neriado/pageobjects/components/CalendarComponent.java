package ru.neriado.pageobjects.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, Integer month, String year) {
        $(".react-datepicker__month-select").selectOption(4);
        $(".react-datepicker__year-select").selectOption("1990");
        $(".react-datepicker__day--017").click();
    }
}
