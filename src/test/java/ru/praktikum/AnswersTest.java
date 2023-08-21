package ru.praktikum;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import ru.praktikum.pages.MainPage;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnswersTest {

    private final By question;
    private final By answer;
    private final String result;

    public AnswersTest(By question, By answer, String result) {
        this.question = question;
        this.answer = answer;
        this.result = result;
    }

    @Rule
    public DriverRule driverRule = new DriverRule();

    @Parameterized.Parameters
    public static Object[][] getOptions() {
        return new Object[][] {
                { MainPage.firstQuestion, MainPage.firstAnswer, "Сутки — 400 рублей. Оплата курьеру — наличными или картой." },
                { MainPage.fourthQuestion, MainPage.fourthAnswer, "Только начиная с завтрашнего дня. Но скоро станем расторопнее." }
        };
    }

    @Test
    public void checkCorrectAnswer() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
                .clickOnCookieButton()
                .clickOnQuestion(question)
                .waitForDisplayingFields(answer);
        assertEquals("Текст не совпадает", result, driverRule.getDriver().findElement(answer).getText());
    }
}