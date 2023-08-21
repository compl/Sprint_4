package ru.praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.praktikum.pages.MainPage;
import ru.praktikum.pages.OrderPage;

/*Честно, не уверен вообще, что параметризация здесь подразумевалась только для деления тестов на разные входы во флоу
оформления заказа - 2 кнопки Заказать. Просто на этом заострили внимание в задании, что типа есть 2 кнопки. В реале я
бы сделал только 1 полный тест с кнопкой в хедере, а другую кнопку просто проверил, что она редиректит куда нужно.
А так получается как-будто слишком избыточно.
Еще не нравится, что публичными сделал статик поля в MainPage, чтобы сюда прокинуть.
Буду благодарен, если напишите, как нужно в идеале сделать.*/

@RunWith(Parameterized.class)
public class OrderScooterTest {

    private static final String NAME = "Илон";
    private static final String SURNAME = "Масков";
    private static final String ADDRESS = "Москва, Лубянка";
    private static final String PHONE = "88005553535";
    private static final String DATE = "10.09.2023";

    private By orderButton;

    public OrderScooterTest(By orderButton) {
        this.orderButton = orderButton;
    }

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Parameterized.Parameters
    public static Object[][] getOrderButtons() {
        return new Object[][] {
                { MainPage.orderButtonInHeader },
                { MainPage.orderButtonInBody }
        };
    }

    @Test
    public void makeOrder() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
                .clickOnCookieButton();

        OrderPage orderPage = mainPage.clickOnOrderButton(orderButton);
        orderPage.waitForDisplayingFields()
                .enterValueInNameField(NAME)
                .enterValueInSurnameField(SURNAME)
                .pickStationInMetroField()
                .enterValueInAddressField(ADDRESS)
                .enterValueInPhoneField(PHONE)
                .clickOnNextButton()
                .pickRentalDurationField()
                .enterValueInDeliveryDateField(DATE)
                .clickOnOrderButton()
                .clickOnYesButton()
                .waitForOrderCreatedLabel();

    }
}