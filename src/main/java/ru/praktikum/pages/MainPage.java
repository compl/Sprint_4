package ru.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.praktikum.EnvConfig;

import java.time.Duration;

public class MainPage {

    private final WebDriver driver;

    //Кнопка Заказать в хедере
    public static final By orderButtonInHeader = By.className("Button_Button__ra12g");
    //Кнопка Заказать ниже в теле страницы
    public static final By orderButtonInBody = By.className("Button_UltraBig__UU3Lp");
    //Кнопка закрытия плашки про куки
    private static final By cookieButton = By.className("App_CookieButton__3cvqF");
    //Первый вопрос в блоке
    public static final By firstQuestion = By.id("accordion__heading-0");
    //Четвертый вопрос в блоке
    public static final By fourthQuestion = By.id("accordion__heading-3");
    //Ответ на первый вопрос
    public static final By firstAnswer = By.xpath(".//div[@id='accordion__panel-0']/p");
    //Ответ на четвертый вопрос
    public static final By fourthAnswer = By.xpath(".//div[@id='accordion__panel-3']/p");


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(EnvConfig.BASE_URL);
        return this;
    }

    public MainPage clickOnCookieButton() {
        driver.findElement(cookieButton).click();
        return this;
    }

    public OrderPage clickOnOrderButton(By orderButton) {
        driver.findElement(orderButton).click();
        return new OrderPage(driver);
    }

    public MainPage clickOnQuestion(By question) {
        driver.findElement(question).click();
        return this;
    }

    public void waitForDisplayingFields(By field) {
        new WebDriverWait(driver, Duration.ofSeconds(EnvConfig.DEFAULT_TIMEOUT))
                .until(ExpectedConditions.visibilityOfElementLocated(field));
    }
}