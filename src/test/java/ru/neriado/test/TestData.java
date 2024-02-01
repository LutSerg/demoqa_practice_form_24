package ru.neriado.test;

import com.github.javafaker.Faker;

import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class TestData {
    Faker faker = new Faker(new Locale("en"));

    String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = getRandomGender(),
            phoneNumber = faker.phoneNumber().subscriberNumber(10),
            setHobbies = getHobbie(),
            setSubject = getSubject(),
            address = faker.address().fullAddress(),
            dayOfBirth = getDay(),
            monthOfBirth = getMonth(),
            yearOfBirth = getYear(),
            photo = "Rattus.jpg",
            state = getState(),
            city = getCity(state),
    modalHead = "Thanks for submitting the form";

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};

        int index = getRandomInt(0, genders.length - 1);

        return genders[index];

    }

    public static String getDay() {
        return String.valueOf(getRandomInt(1, 28));
    }

    private String getSubject() {

        return faker.options().option("Maths",
                "History",
                "English",
                "Arts",
                "Computer Science",
                "Physics");
    }

    private String getMonth() {

        return faker.options().option("January",
                "February",
                "March",
                "April",
                "May",
                "June",
                "July",
                "August",
                "September",
                "October",
                "November",
                "December");
    }

    public static String getYear() {
        return String.valueOf(getRandomInt(1900, 2050));

    }

    private String getHobbie() {

        return faker.options().option("Sports",
                "Reading",
                "Music");
    }

    public String getState() {
        return faker.options().option("NCR", "Uttar Pradesh", "Haryana", "Rajasthan");

    }

    public String getCity(String state) {
        if (state.equals("NCR")) {
            return faker.options().option("Delhi", "Gurgaon", "Noida");
        }

        if (state.equals("Uttar Pradesh")) {
            return faker.options().option("Agra", "Lucknow", "Merrut");
        }

        if (state.equals("Haryana")) {
            return faker.options().option("Karnal", "Panipat");
        }

        if (state.equals("Rajasthan")) {
            return faker.options().option("Jaipur", "Jaiselmer");
        }

        return null;
    }

}

