package ru.netology.generator;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Locale;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateName(String locale) {
        User user = Registration.generateByCard(locale);
        return user.name;
    }

    public static String generatePhone(String locale) {
        User user = Registration.generateByCard(locale);
        return user.phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static User generateByCard(String locale) {
            Faker faker = new Faker(new Locale(locale));
            return new User(
                    faker.name().fullName(),
                    faker.phoneNumber().phoneNumber()
            );
        }
    }

    @Data
    @RequiredArgsConstructor
    public static class User {
        private final String name;
        private final String phone;
    }
}
