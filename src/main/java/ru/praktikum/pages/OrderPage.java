package ru.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum.EnvConfig;

import java.time.Duration;

public class OrderPage {

    private final WebDriver driver;

    private static final By nameField = By.cssSelector("[placeholder = '* Имя']");
    private static final By surnameField = By.cssSelector("[placeholder = '* Фамилия']");
    private static final By metroDropdown = By.cssSelector("[placeholder = '* Станция метро']");
    private static final By metroStationSokolnikiOption = By.xpath(".//ul[@class='select-search__options']/li[9]/button");
    private static final By addressField = By.cssSelector("[placeholder = '* Адрес: куда привезти заказ']");
    private static final By phoneField = By.cssSelector("[placeholder = '* Телефон: на него позвонит курьер']");
    private static final By nextButton = By.className("Button_Middle__1CSJM");
    private static final By deliveryDateField = By.cssSelector("[placeholder = '* Когда привезти самокат']");
    private static final By rentalDurationDropdown = By.xpath(".//div[text()='* Срок аренды']");
    private static final By twoDaysDurationOption = By.xpath(".//div[text()='двое суток']");
    private static final By orderButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    private static final By yesButton = By.xpath(".//button[text()='Да']");
    private static final By orderCreatedLabel = By.xpath(".//div[text()='Заказ оформлен']");

    public OrderPage(WebDriver driver) {
        this.driver = driver;
    }

    public OrderPage waitForDisplayingFields() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(nameField));
        return this;
    }

    public OrderPage enterValueInNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    public OrderPage enterValueInSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
        return this;
    }

    public OrderPage pickStationInMetroField() {
        driver.findElement(metroDropdown).click();
        driver.findElement(metroStationSokolnikiOption).click();
        return this;
    }

    public OrderPage enterValueInAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
        return this;
    }

    public OrderPage enterValueInPhoneField(String phone) {
        driver.findElement(phoneField).sendKeys(phone);
        return this;
    }

    public OrderPage clickOnNextButton() {
        driver.findElement(nextButton).click();
        return this;
    }

    public OrderPage enterValueInDeliveryDateField(String date) {
        driver.findElement(deliveryDateField).sendKeys(date);
        return this;
    }

    public OrderPage pickRentalDurationField() {
        driver.findElement(rentalDurationDropdown).click();
        driver.findElement(twoDaysDurationOption).click();
        return this;
    }

    public OrderPage clickOnOrderButton() {
        driver.findElement(orderButton).click();
        return this;
    }

    public OrderPage clickOnYesButton() {
        driver.findElement(yesButton).click();
        return this;
    }

    public void waitForOrderCreatedLabel() {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(orderCreatedLabel));
    }
}
