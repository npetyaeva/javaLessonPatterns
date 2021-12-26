package ru.netology.page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class OrderPage {
    private final String currentUrl = "http://localhost:9999/";
    private final SelenideElement city = $("[placeholder = 'Город']");
    private final SelenideElement date = $("[placeholder = 'Дата встречи']");
    private final SelenideElement name = $("[name = 'name']");
    private final SelenideElement phone = $("[name = 'phone']");
    private final SelenideElement agree = $(".checkbox__text");
    private final SelenideElement button = $(".button");
    private final SelenideElement successMessage = $("[data-test-id='success-notification'] .notification__content");
    private final SelenideElement replanMessage = $("[data-test-id='replan-notification'] .notification__content");
    private final SelenideElement replanButton = $("[data-test-id='replan-notification'] .button .button__text");
    private final SelenideElement closeButton = $("[data-test-id='success-notification'] button");

    public OrderPage() {
        Selenide.open(currentUrl);
    }

    public void successOrder(OrderInfo info, String dateDelivery) {
        city.setValue(info.getCity());
        date.doubleClick().sendKeys(Keys.BACK_SPACE);
        date.setValue(dateDelivery);
        name.setValue(info.getName());
        phone.setValue(info.getPhone());
        agree.click();
        button.click();
    }

    public void clear() {
        city.sendKeys(Keys.CONTROL, "A");
        city.sendKeys(Keys.BACK_SPACE);
        name.sendKeys(Keys.CONTROL, "A");
        name.sendKeys(Keys.BACK_SPACE);
        phone.sendKeys(Keys.CONTROL, "A");
        phone.sendKeys(Keys.BACK_SPACE);
        agree.click();
    }

    public void checkFirstDelivery(String dateDelivery) {
        successMessage.shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(exactText("Встреча успешно запланирована на " + dateDelivery));
        closeButton.click();
    }

    public void checkSecondDelivery(String dateDelivery) {
        replanMessage.shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(text("У вас уже запланирована встреча на другую дату. Перепланировать?"));
        replanButton.click();
        successMessage.shouldBe(visible, Duration.ofSeconds(15))
                .shouldHave(exactText("Встреча успешно запланирована на " + dateDelivery));
    }
}
