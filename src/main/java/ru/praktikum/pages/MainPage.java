package ru.praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.praktikum.EnvConfig;

public class MainPage {

    private final WebDriver driver;

    public static final By orderButtonInHeader = By.className("Button_Button__ra12g");
    public static final By orderButtonInBody = By.className("Button_UltraBig__UU3Lp");
    private static final By cookieButton = By.className("App_CookieButton__3cvqF");
    public static final By firstQuestion = By.xpath(".//div[text()='Сколько это стоит? И как оплатить?']");
    public static final By firstAnswer = By.xpath(".//div/p[text()='Сутки — 400 рублей. Оплата курьеру — наличными или картой.']");
    public static final By secondQuestion = By.xpath(".//div[text()='Хочу сразу несколько самокатов! Так можно?']");
    public static final By secondAnswer = By.xpath(".//div/p[text()='Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.']");


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

    public void clickOnQuestion(By question) {
        driver.findElement(question).click();
    }
}
