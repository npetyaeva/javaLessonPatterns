package ru.netology.test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.data.DataGenerator;
import ru.netology.page.OrderInfo;
import ru.netology.page.OrderPage;

public class DeliveryCardTest {
    private OrderPage orderPage;

    @BeforeAll
    static void setUpAll() {
        Configuration.browser = "chrome";
    }

    @BeforeEach
    void setUp() {
        orderPage = new OrderPage();
    }

    @Test
    void shouldCheckChangeDate() {
        String firstDate = DataGenerator.generateDate(5);
        String secondDate = DataGenerator.generateDate(7);
        OrderInfo info = DataGenerator.generateInfoForOrder("ru");

        orderPage.successOrder(info, firstDate);
        orderPage.checkFirstDelivery(firstDate);
        orderPage.clear();

        orderPage.successOrder(info, secondDate);
        orderPage.checkSecondDelivery(secondDate);
    }
}
