package ru.netology.data;

import com.github.javafaker.Faker;
import ru.netology.page.OrderInfo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {

    public static OrderInfo generateInfoForOrder(String local) {
        Faker faker = new Faker(new Locale(local));
        List<String> cities = Arrays.asList("Екатеринбург", "Йошкар-Ола", "Калининград", "Калуга", "Кострома", "Краснодар",
                "Красноярск", "Курган", "Махачкала", "Петропавловск-Камчатский", "Сыктывкар", "Чебоксары",
                "Владикавказ", "Абакан", "Москва", "Казань", "Майкоп");
        Random random = new Random();

        return new OrderInfo(cities.get(random.nextInt(cities.size())),
                faker.name().lastName().replace("ё", "е") + " " + faker.name().firstName().replace("ё", "е"),
                faker.numerify("+7##########"));
    }

    public static String generateDate(int days) {
        return LocalDate.now().plusDays(days).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }

}

