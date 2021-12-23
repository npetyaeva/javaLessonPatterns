package ru.netology;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.utils.DataGenerator;
import ru.netology.utils.OrderInfo;
import ru.netology.utils.OrderPage;

public class DeliveryCardTest {
    private final OrderPage orderPage = new OrderPage();

    @BeforeAll
    static void setUpAll() {
        Configuration.browser = "chrome";
    }

    @BeforeEach
    void setUp() {
        orderPage.open();
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
