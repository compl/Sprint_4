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
    //Второй вопрос в блоке
    public static final By secondQuestion = By.id("accordion__heading-1");
    //Третий вопрос в блоке
    public static final By thirdQuestion = By.id("accordion__heading-2");
    //Четвертый вопрос в блоке
    public static final By fourthQuestion = By.id("accordion__heading-3");
    //Пятый вопрос в блоке
    public static final By fifthQuestion = By.id("accordion__heading-4");
    //Шестой вопрос в блоке
    public static final By sixthQuestion = By.id("accordion__heading-5");
    //Седьмой вопрос в блоке
    public static final By seventhQuestion = By.id("accordion__heading-6");
    //Восьмой вопрос
    public static final By eighthQuestion = By.id("accordion__heading-7");
    //Ответ на первый вопрос
    public static final By firstAnswer = By.xpath(".//div[@id='accordion__panel-0']/p");
    //Ответ на второй вопрос
    public static final By secondAnswer = By.xpath(".//div[@id='accordion__panel-1']/p");
    //Ответ на третий вопрос
    public static final By thirdAnswer = By.xpath(".//div[@id='accordion__panel-2']/p");
    //Ответ на четвертый вопрос
    public static final By fourthAnswer = By.xpath(".//div[@id='accordion__panel-3']/p");
    //Ответ на пятый вопрос
    public static final By fifthAnswer = By.xpath(".//div[@id='accordion__panel-4']/p");
    //Ответ на шестой вопрос
    public static final By sixAnswer = By.xpath(".//div[@id='accordion__panel-5']/p");
    //Ответ на седьмой вопрос
    public static final By seventhAnswer = By.xpath(".//div[@id='accordion__panel-6']/p");
    //Ответ на восьмой вопрос
    public static final By eighthAnswer = By.xpath(".//div[@id='accordion__panel-7']/p");


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