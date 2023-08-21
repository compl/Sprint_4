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

    private By question;
    private By answer;
    private String result;

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
                { MainPage.secondQuestion, MainPage.secondAnswer, "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим." }
        };
    }

    @Test
    public void checkCorrectAnswer() {
        MainPage mainPage = new MainPage(driverRule.getDriver());
        mainPage.open()
                .clickOnCookieButton()
                .clickOnQuestion(question);
        assertEquals("Текст не совпадает", result, driverRule.getDriver().findElement(answer).getText());
    }

}
